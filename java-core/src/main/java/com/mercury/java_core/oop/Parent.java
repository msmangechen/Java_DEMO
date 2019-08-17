package com.mercury.java_core.oop;

public class Parent {
	
	int t = 0;
	static int q = 0;

	Parent(String name) {
		System.out.println("Parent");
	}
	
	static {
		System.out.println("static in Parent");
	}
	
	{
		System.out.println("non-static in Parent");
	}
	
	static void test() {
		
	}
	
	void printT() {
		System.out.println("t in Parent: " + t);
		System.out.println("q in Parent: " + q);
	}
	
	static void printStatic() {
		System.out.println("static in Parent");
	}
	
}
