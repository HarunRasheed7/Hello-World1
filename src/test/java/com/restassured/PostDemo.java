package com.restassured;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class PostDemo {
	
	@Test
	void t1Post() {
		JSONObject request=new JSONObject();
		request.put("name", "Harun");
		request.put("job","Engineer");
		
	given().
	header("Content-Type","application/json").
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	post("https://reqres.in/api/users").
	then().
	statusCode(201).log().all();
	}
	
	@Test
	void t2Put() {
		JSONObject request=new JSONObject();
		request.put("name", "Rasheed");
		request.put("job","Engineer");
		
	given().
	header("Content-Type","application/json").
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	put("https://reqres.in/api/users/2").
	then().
	statusCode(200).log().all();
	}
	
	@Test
	void t3Patch() {
		JSONObject request=new JSONObject();
		request.put("name", "Rashid");
		request.put("job","Engineer");
		
	given().
	header("Content-Type","application/json").
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	patch("https://reqres.in/api/users/2").
	then().
	statusCode(200).log().all();
	}
	
	@Test
	void t4Delete() {
		
	when().
	delete("https://reqres.in/api/users/2").
	then().
	statusCode(204).log().all();

}
}
