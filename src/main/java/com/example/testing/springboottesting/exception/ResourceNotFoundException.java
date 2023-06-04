package com.example.testing.springboottesting.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
	public ResourceNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
