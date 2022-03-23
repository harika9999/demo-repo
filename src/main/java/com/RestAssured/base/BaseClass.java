package com.RestAssured.base;

import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

/**
	 * @author Dillibai B
	 *
	 */
	public class BaseClass {
		
		ResourceBundle conf = ResourceBundle.getBundle("common-resources");	
		
//		ResourceBundle conf = ResourceBundle.getBundle("Resources/org-resources.properties");	
		
//		FileInputStream fis = new FileInputStream("Resources/org-resources.properties");
//		   resourceBundle = new PropertyResourceBundle(fis);
		
		protected String apiKey=conf.getString("apiKey");
		
		@BeforeTest
		public void setUp() {
			RestAssured.baseURI = conf.getString("BaseApiURL");
//			System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

		}


}

