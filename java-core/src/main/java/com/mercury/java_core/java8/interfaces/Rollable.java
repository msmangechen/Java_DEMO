package com.mercury.java_core.java8.interfaces;

public interface Rollable {

	void roll();
	
	default void test2() {
		System.out.println("default test in Rollable");
	}
	
}
