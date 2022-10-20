package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {
	@JsonProperty("lastname")
	private String lastName;
	
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonProperty("email")
	private String emailAddress;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("day")
	private String day;

	@JsonProperty("month")
	private String month;
	
	@JsonProperty("year")
	private String year;

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}
	
	public String getDay() {
		return day;
	}
	
	
	public String getMonth() {
		return month;
	}
	
	
	public String getYear() {
		return year;
	}

}
