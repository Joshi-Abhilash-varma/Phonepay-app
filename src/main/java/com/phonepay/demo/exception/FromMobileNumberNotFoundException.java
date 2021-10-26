package com.phonepay.demo.exception;

public class FromMobileNumberNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public FromMobileNumberNotFoundException(String message) {
		super(message);

	}

	public FromMobileNumberNotFoundException(String message, Throwable t) {
		super(message, t);

	}
}
