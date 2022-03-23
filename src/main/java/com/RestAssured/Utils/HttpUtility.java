package com.RestAssured.Utils;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.RestAssured.base.BaseClass;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * The Class HttpUtility.
 */
/**
 * @author Dillibai B
 *
 */
public class HttpUtility extends BaseClass {

	/** The conf. */

	ResourceBundle conf = ResourceBundle.getBundle("common-resources");
	
	public boolean scanStatus;
	public JSONObject scanresp;

	/**
	 * Post body.
	 *
	 * @param postUrl  the post url
	 * @param postBody the post body
	 * @return the JSON object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */

	public JSONObject postBody(String postUrl, String postBody) throws IOException {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBody(postBody);
		builder.setContentType("application/json; charset=UTF-8");
		RequestSpecification requestSpec = builder.build();
		Response response = RestAssured.given().header("Authorization", "Bearer " + apiKey)
				.spec(requestSpec).when().post(postUrl);
//		System.out.println(response.body().asString());
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
//		System.out.println(JSONResponseBody);
//		System.out.println(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());
		Reporter.log(response.asString());

		return JSONResponseBody;
	}

	public JSONObject uploadFile(String postUrl, File filelocation, String orgId) {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		RequestSpecification requestSpec = builder.build();

		Response response = RestAssured.given()

				.header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey).spec(requestSpec)
				.header("Content-Type", "multipart/form-data").pathParam("orgId", orgId)
				.multiPart("?fileName", filelocation, "multipart/form-data").when().post(postUrl);
		System.out.println(postUrl + "?fileName");
//				.when().post(conf.getString("uploadexcel")+"?orgId="+this.uuid);
//				.when().post(postUrl+"?"+orgId);
//				.when().post(postUrl+":"+orgId);

		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		System.out.println(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());
		Reporter.log(response.asString());

		return JSONResponseBody;
	}

	public JSONObject postwithoutBody(String postUrl, String reqId, String orgId) throws IOException {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType("application/json; charset=UTF-8");
		RequestSpecification requestSpec = builder.build();
		Response response = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey)
				.spec(requestSpec).pathParam("orgId", orgId).pathParam("reqId", reqId).when().post(postUrl);
//		System.out.println(response.body().asString());

		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
//		System.out.println(JSONResponseBody);
//		System.out.println(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());
		Reporter.log(response.asString());

		return JSONResponseBody;
	}

	public JSONObject postwithoutBody(String postUrl, String orgId) throws IOException {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType("application/json; charset=UTF-8");
		RequestSpecification requestSpec = builder.build();
		Response response = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey)
				.spec(requestSpec).pathParam("orgId", orgId).when().post(postUrl);
//		System.out.println(response.body().asString());

		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
//		System.out.println(JSONResponseBody);
//		System.out.println(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());
		Reporter.log(response.asString());

		return JSONResponseBody;
	}

	/**
	 * Post array.
	 *
	 * @param postUrl  the post url
	 * @param postBody the post body
	 * @return the JSON array
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public JSONArray postArray(String postUrl, String postBody) throws IOException {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBody(postBody);
		builder.setContentType("application/json; charset=UTF-8");
		RequestSpecification requestSpec = builder.build();
		Response response = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey)
				.spec(requestSpec).when().post(postUrl);
		JSONArray JSONResponseBody = new JSONArray(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());
		return JSONResponseBody;
	}

	/**
	 * @param apiUrl
	 * @throws JsonException
	 * @throws IOException
	 */
	public String ResponseCode(String apiUrl) throws JsonException, IOException {
		// ResourceBundle conf = ResourceBundle.getBundle("common-resources");
		// RestAssured.baseURI = conf.getString("BaseApiURL");
		Response resp = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey).when()
				.get(apiUrl).then().extract().response();
		// JSONObject response=new JSONObject(resp.body().asString());
		Reporter.log(resp.asString());
		String APIresp = resp.asString();
		return APIresp;
	}

	public String GetResponseCodewithParam(String apiUrl, String orgId) throws JsonException, IOException {
		// ResourceBundle conf = ResourceBundle.getBundle("common-resources");
		// RestAssured.baseURI = conf.getString("BaseApiURL");
		Response resp = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey).when()
				.pathParam("orgId", orgId).get(apiUrl).then().extract().response();
		// JSONObject response=new JSONObject(resp.body().asString());
		Reporter.log(resp.asString());
		String APIresp = resp.asString();
		return APIresp;
	}

	public String GetResponseCodewithParams(String apiUrl, String orgId, String userId)
			throws JsonException, IOException {
		// ResourceBundle conf = ResourceBundle.getBundle("common-resources");
		// RestAssured.baseURI = conf.getString("BaseApiURL");
		Response resp = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey).when()
				.pathParam("orgId", orgId).pathParam("userId", userId).get(apiUrl).then().extract().response();
		// JSONObject response=new JSONObject(resp.body().asString());
		Reporter.log(resp.asString());
		String APIresp = resp.asString();
		return APIresp;
	}

	/**
	 * @param url
	 * @param uuid
	 * @param apiBody
	 * @return
	 * @throws Exception
	 */
	public JSONObject putBody(String url, String uuid, String apiBody) throws Exception {
		Response response = null;
		RestAssured.baseURI = conf.getString("BaseApiURL");

		try {
			response = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey)
					.contentType(ContentType.JSON).body(apiBody).put(url + uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());

		return JSONResponseBody;

	}

	public JSONObject putBodywithParams(String url, String orgId, String uploadId) throws Exception {
		Response response = null;
		RestAssured.baseURI = conf.getString("BaseApiURL");
		
		try {
			response = RestAssured.given().header("Authorization", "Bearer " + apiKey).header("apiKey", apiKey)
					.contentType(ContentType.JSON).pathParam("orgId", orgId).pathParam("uploadId", uploadId)
					.put(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Reporter.log("API Response:");
		Reporter.log(JSONResponseBody.toString());

		return JSONResponseBody;

	}


	
	

	
	
	
	
	
	
	
	
	
	



	static int MAX = 26;

	// Returns a String of random alphabets of
	// length n.

	/**
	 * @param n
	 * @return
	 */
	public static String randomString(int n) {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		String res = "";
		for (int i = 0; i < n; i++)
			res = res + alphabet[(int) (Math.random() * 10 % MAX)];
		return res;
	}

	/**
	 * @return
	 */
	public String panNumber() {
		String PAN;
		PAN = "BA1034";
		PAN = randomString(1) + randomString(1) + randomString(1) + PAN + randomString(1);
		return PAN;
	}

	public String aadhar(int n) {
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String aadhar = "";
		for (int i = 0; i < n; i++)
			aadhar = aadhar + num[(int) (Math.random() * 10 % MAX)];

		;
		return aadhar;
	}

	/**
	 * @param result
	 */
	@AfterMethod
	public void testFailure(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				System.out.println(result);
				HttpUtility.appendStrToFile("UUID_Storage.txt", "Test Failure");
				HttpUtility.appendStrToFile("UUID_Storage.txt", "Test Failure");
			} catch (Exception e) {
				System.out.println("Exception" + e.getMessage());
			}
		}
	}

	/**
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public String read(int n) throws Exception {

		String ab = "";
		String st = Files.readAllLines(Paths.get("UUID_Storage.txt")).get(n);
		ab = ab + st;
		return ab;
	}

	/**
	 * @param fileName
	 * @param str
	 */
	public static void appendStrToFile(String fileName, String str) {
		try {

			// Open given file in append mode.
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			out.newLine();
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
		}
	}

	/**
	 * @param apiUrl
	 * @throws Exception
	 */
	public void delete(String apiUrl) throws Exception {
		RestAssured.baseURI = conf.getString("BaseApiURL");
		Response resp = RestAssured.given().header("apiKey", apiKey).when().delete(apiUrl).then().extract().response();
		Reporter.log(resp.asString());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
}
