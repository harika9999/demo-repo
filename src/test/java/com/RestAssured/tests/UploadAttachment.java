package com.RestAssured.tests;


import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UploadAttachment {
	
	
	@Test
	public void UploadAttach() {
		
			File file = new File("");
			String token = "";
			String postUrl = "";
			
			Response response = RestAssured.given().header("authorization","Bearer "+token )
	                .multiPart("application/json",file)
					.when().post(postUrl);

			String body = response.getBody().asString();
			System.out.println(body);
			int code = response.getStatusCode();
			System.out.println(code);

	}

}











//
//given().header("Authorization", "Bearer " + token).accept(ContentType.JSON).when().post(postUrl)
//.then().statusCode(200);