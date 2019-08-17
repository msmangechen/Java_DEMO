package com.mercury.java_core.test_exception;

public class CustomCheckedException extends Exception {

	// constructor为了提供自己的message
	CustomCheckedException(String message) {
		super(message); // use super() to invoke exception class to handle the message
	}
	
}
