package com.mercury.java_core.test_exception;

public class CustomUncheckedException extends RuntimeException {
	
	// 支持没有argument
	CustomUncheckedException() {
	}
	
	// 支持有argument
	CustomUncheckedException(String message) {
		super(message);
	}
	
}
