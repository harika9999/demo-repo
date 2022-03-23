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
@JsonPropertyOrder({
"pincode",
"clientRefId",
"city",

})
public class Addresses {

@JsonProperty("pincode")
public String pincode;
@JsonProperty("clientRefId")
public String clientRefId;
@JsonProperty("city")
public String city;

@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Addresses() {
}

/**
* 
* @param pincode
* @param clientRefId
* @param city
*/
public Addresses(String pincode, String clientRefId) {
super();
this.pincode = pincode;
this.clientRefId = clientRefId;

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

