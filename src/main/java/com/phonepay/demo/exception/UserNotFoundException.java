package com.phonepay.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)

public class UserNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);

	}

	public UserNotFoundException(String message, Throwable t) {
		super(message, t);

	}

}
