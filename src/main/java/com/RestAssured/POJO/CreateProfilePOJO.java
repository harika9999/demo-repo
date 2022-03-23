package com.RestAssured.POJO;


	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import com.fasterxml.jackson.annotation.JsonAnyGetter;
	import com.fasterxml.jackson.annotation.JsonAnySetter;
	import com.fasterxml.jackson.annotation.JsonIgnore;
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "consentTaken", "gender", "Jobrole", "employeeStatus", "fName", "lName", "employeeType", "dob",
			"consentAttachment", "action", "location", "jobRole", "startDate" })
	public class CreateProfilePOJO {

		@JsonProperty("consentTaken")
		public String consentTaken;
		@JsonProperty("gender")
		public String gender;
		@JsonProperty("addresses")
		public Addresses[] Addresses;
	
		
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		public CreateProfilePOJO() {
		}

		/**
		 * 
		 * @param consentTaken
		 * @param gender
		 **/


		public CreateProfilePOJO(String consentTaken, String gender, Addresses[] Addresses
				) {
			
			super();
			this.consentTaken = consentTaken;
			this.gender = gender;
			this.Addresses = Addresses;
		}

	

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}

