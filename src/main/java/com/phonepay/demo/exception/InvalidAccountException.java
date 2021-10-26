package com.phonepay.demo.exception;

public class InvalidAccountException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidAccountException(String message) {
		super(message);

	}

	public InvalidAccountException(String message, Throwable t) {
		super(message, t);

	}

}
