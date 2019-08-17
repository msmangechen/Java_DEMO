package com.mercury.java_core.java8.interfaces;

public interface Playable {

	void play();

	// static method, class level, not relay on interface
	// cannot override, 不需要instance
	static void test1() {
		System.out.println("static test 1 in Playable");
	}
	
	// can override
	default void test2() {
		System.out.println("default test2 in Playable");
	}

}
