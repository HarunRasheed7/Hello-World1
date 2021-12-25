package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class practice {
	@Test
	void practicee() {
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		String res=given().get().asPrettyString();
		JsonPath json=new JsonPath(res);
		
		
	
		
	}

}
