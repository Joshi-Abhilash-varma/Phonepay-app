package com.phonepay.demo.exception;

public class ToMobileNumberNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ToMobileNumberNotFoundException(String message) {
		super(message);

	}

	public ToMobileNumberNotFoundException(String message, Throwable t) {
		super(message, t);

	}

}
