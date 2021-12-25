package com.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class GetDemo {
	//@Test
	void t1Get() {
		Response response = get("https://reqres.in/api/users?page=2");
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asPrettyString());
//		System.out.println(response.getStatusLine());
//		System.out.println(response.getTime());
//		System.out.println(response.getHeader("content-type"));
//		Assert.assertEquals(response.getStatusCode(), 200);
		String res = response.asString();
		JsonPath json=new JsonPath(res);
		//Object int1 = json.getList("data");
		List<Object> list = json.getList("data");
		List<String> email=new ArrayList<String>();
		for (int i = 0; i <list.size(); i++) {
			
		
		String path = response.then().extract().path("data["+i+"].email");
		email.add(path);
		//System.out.println(path);
		
		}
		
		System.out.println(email.get(1));
	
		
}
	//@Test
	void t1validation() {
		given().get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200)
		.body("data.id[0]", equalTo(7)).body("data.firstname",hasItems("Michael","Lindsay"));
	}
	
	//@Test
	void githubApi() {
		RestAssured.baseURI ="https://api.github.com";
		RestAssured.basePath ="/user/repos";
	    String Token="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";
		
	Response res =given().auth().oauth2(Token).contentType(ContentType.JSON).when().body("{\r\n" + 
			"    \"name\": \"Hello-World1\",\r\n" + 
			"    \"description\": \"This is your repository\",\r\n" + 
			"    \"homepage\": \"https://github.com\",\r\n" + 
			"    \"private\": false,\r\n" + 
			"    \"has_issues\": true,\r\n" + 
			"    \"has_projects\": true,\r\n" + 
			"    \"has_wiki\": true\r\n" + 
			"}").post();
	System.out.println(res.getStatusCode());
	System.out.println(res.getStatusLine());
	}
	@Test
	void apiTest() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		String s = response.asPrettyString();
		//System.out.println(s);
		JsonPath json=new JsonPath(s);
		List<Object> list = json.getList("data");
		//System.out.println(list);
		List<String> firstName=new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String path = response.then().extract().path("data["+i+"].first_name");
			firstName.add(path);
		}
		System.out.println(firstName);
	}
	
	
}
