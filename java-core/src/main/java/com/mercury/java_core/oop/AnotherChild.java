package com.mercury.java_core.oop;

public class AnotherChild extends Parent {

	int t2 = 0;
	int t = -2;
	static int q = -2;

	AnotherChild(String name) {
		super(name);
	}

	void printT2() {
		System.out.println("t2 in AnotherChild: " + t2);
	}

	void printT() {
		System.out.println("t in AnotherChild: " + t);
		System.out.println("q in AnotherChild: " + q);
	}

	static void printStatic() {
		System.out.println("static in AnotherChild");
	}

}
