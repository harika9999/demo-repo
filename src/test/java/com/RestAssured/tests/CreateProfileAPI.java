package com.RestAssured.tests;

import java.io.File;
import java.util.ResourceBundle;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.RestAssured.POJO.Addresses;
import com.RestAssured.POJO.CreateProfilePOJO;
import com.RestAssured.Utils.GenericMethods;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ob.ExcelOnboarding.Utilities.HttpUtility;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProfileAPI {
	
	
	ResourceBundle conf = ResourceBundle.getBundle("common-resources");
	protected String uuid;
	protected String orgId;
	protected String reqId;
	/** The utility. */
	HttpUtility utility = new HttpUtility();

	@Test
	public void post() throws JsonProcessingException {
		
		
		String createOrgUrl = conf.getString("OrgUrl");
		String orgName = conf.getString("NameValue");
		orgName = orgName + Long.toString(System.currentTimeMillis());
		String organisation = conf.getString("OrgName");
		String apiBody = conf.getString("orgPostBody");
//		    System.out.println(apiBody);
		JSONObject reqJson = new JSONObject(apiBody);
//		    System.out.println(reqJson);
		reqJson.put("legalName", orgName + " Pvt Ltd");
		reqJson.put("name", orgName);
		String docNum = utility.panNumber();
		reqJson.getJSONObject("document").put("documentNumber", docNum);
		JSONObject resp = utility.postBody(createOrgUrl, reqJson.toString());
//		System.out.println(resp);
		String result1 = resp.getString("name");
//		System.out.println(result1);
		Assert.assertEquals(result1, orgName);
//		    System.out.println("org Body \n"+reqJson);
		Reporter.log("Organisation Created");
//		uuid = resp.getString("uuid");
		uuid = "0eb10f64-544e-4ca3-9369-e1e1b199dd71";



	}
}
