package com.pactera.spring.exception;

public class NameOrPwdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6670275938545010571L;
	public NameOrPwdException() {

	}
	
	public NameOrPwdException(String message) {

		super(message);
	}
	
	public NameOrPwdException(Throwable cause) {
		super(cause);
	}
	public NameOrPwdException(String message ,Throwable cause) {
		super(message,cause);
	}
	
}
