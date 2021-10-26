package com.phonepay.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonepay.demo.dto.UserRegisterDto;
import com.phonepay.demo.service.Impl.UserRegisterServiceImpl;

@Validated
@RestController
@RequestMapping("/pays")
public class UserRegisterController {
	
	@Autowired
	UserRegisterServiceImpl userRegisterServiceImpl;
	
	@PostMapping("/userregisterinfo")
	public ResponseEntity<String> addUserRegister(@Valid @RequestBody UserRegisterDto userRegisterDto ) throws Exception {
		String response= userRegisterServiceImpl.addNewUserRegisterDetails(userRegisterDto);
		return new ResponseEntity<String>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/port")
	public String getBankServicePortNo() {
		return userRegisterServiceImpl.getBankServicePortNo();
	}
	
}
