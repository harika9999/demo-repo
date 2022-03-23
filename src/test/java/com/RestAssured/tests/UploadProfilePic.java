package com.RestAssured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UploadProfilePic {
	
	@Test
	public void uploadprofilepic() {
	
	String postUrl = "";
	String token = "";

	Response response = RestAssured.given().header("authorization","Bearer "+token ).when().post(postUrl);

	String body = response.getBody().asString();
	System.out.println(body);
	int code = response.getStatusCode();
	System.out.println(code);
	
	Assert.assertEquals(code, 400);
	
	
	
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
//		String token = "ef868864-435d-4614-b412-6b1cfb81a96d";
//		String postUrl = "https://api-dev.betterplace.co.in/api/api-onboarding/public/v2/uploadProfilePic?referenceType=employee&referenceId=d16d830b-5299-486e-99fc-4092c751b7ac";
//		Response response = RestAssured.given().header("authorization","Bearer "+token ).when().post(postUrl);
//		String body = response.getBody().asString();
//		System.out.println(body);
//		given().header("Authorization", "Bearer " + token).accept(ContentType.JSON).when().post(postUrl)
//				.then().statusCode(400);
	
