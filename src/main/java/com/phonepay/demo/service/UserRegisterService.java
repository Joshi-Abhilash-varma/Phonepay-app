package com.phonepay.demo.service;


import javax.validation.constraints.NotNull;

import com.phonepay.demo.dto.UserRegisterDto;
import com.phonepay.demo.exception.UserNotFoundException;


public interface UserRegisterService {

	public String addNewUserRegisterDetails(@NotNull UserRegisterDto userRegisterDto) throws UserNotFoundException;
	
	
	//public UserRegisterDto getMobileDetails(String mobileNumber); 
	
	
	String getBankServicePortNo();
	
	
}
