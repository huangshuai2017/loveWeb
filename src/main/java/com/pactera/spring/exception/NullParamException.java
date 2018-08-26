package com.pactera.spring.exception;

public class NullParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5583910805338225116L;
	public NullParamException() {
		
	}
	public NullParamException(String message) {
		super(message);
	}
	public NullParamException(String message,Throwable cause) {
		super(message, cause);
	}
	public NullParamException(Throwable cause) {
		super(cause);
	}
}
