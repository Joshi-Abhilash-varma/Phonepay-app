package com.phonepay.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDto {
	
	@NotEmpty(message = "firstName should not be empty")
	@Size(min= 3, max = 10, message = "firstName should be less than 20 characters only")
	private String firstName;
	
	@NotEmpty(message = "lastName should not be empty")
	@Size(min= 3, max = 10, message = "firstName should be less than 20 characters only")
	private String lastName;
	
	@NotEmpty(message = "Please provide a Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Provide valid Mobile Number")
	@Size(min = 5, max = 10, message = "phone number is of 10 digits")
	@Max(10)
	private String mobileNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


}
