package com.phonepay.demo.exception;

public class ExceptionHandle extends RuntimeException{
	
	
	private String string;

	public ExceptionHandle(String string) {
		super();
		this.string = string;
	}
	
	
	
}
