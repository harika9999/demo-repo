package com.RestAssured.Utils;
import org.apache.commons.lang3.RandomStringUtils;


public class GenericMethods {
	
		public String generateRandomString(int length) {
			return RandomStringUtils.randomAlphabetic(length);
		}

		public String generateRandomNumber(int length) {
			String allowedChars = "123456789";
			return RandomStringUtils.random(length, allowedChars);
		}

		public String generateRandomAlphaNumeric(int length) {
			
			String allowedChars = "12345678";
			String temp = RandomStringUtils.random(length, allowedChars);		
			String PAN = "COSPB" + temp + "P"; 
			return PAN;
		}

		public String generateStringWithAllobedSplChars(int length, String allowdSplChrs) {
			String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
					"1234567890" + // numbers
					allowdSplChrs;
			return RandomStringUtils.random(length, allowedChars);
		}

		public String generateEmail(int length) {
			String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
					"1234567890" ; // numbers
					//"_-."; // special characters
			String email = "";
			String temp = RandomStringUtils.random(length, allowedChars);
			email = temp.substring(0, temp.length() - 9) + "@test.org";
			return email;
		}
		
		public String generatePhoneNumber(int length) {
			String allowedChars = "1234567890";		
			String temp = RandomStringUtils.random(length, allowedChars);		
//			String contactNumber = "892" + temp;
			return temp;
		}

		public String generateUrl(int length) {
			String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
					"1234567890" + // numbers
					"_-."; // special characters
			String url = "";
			String temp = RandomStringUtils.random(length, allowedChars);
			url = temp.substring(0, 3) + "." + temp.substring(4, temp.length() - 4) + "."
					+ temp.substring(temp.length() - 3);
			return url;
		}

}
