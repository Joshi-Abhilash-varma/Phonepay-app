package com.phonepay.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.phonepay.demo.entity.UserRegister;

public class PhonePayBankRepsonse {

	private UserRegister userRegister = new UserRegister();
	
	private List<BankResponse> phonepays = new ArrayList<>();

	public UserRegister getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}

	public List<BankResponse> getPhonepays() {
		return phonepays;
	}

	public void setPhonepays(List<BankResponse> phonepays) {
		this.phonepays = phonepays;
	}
	
	
}
