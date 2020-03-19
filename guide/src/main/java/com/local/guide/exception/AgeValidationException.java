package com.local.guide.exception;


public class AgeValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgeValidationException(String message) {
		super(message);
	}
}
