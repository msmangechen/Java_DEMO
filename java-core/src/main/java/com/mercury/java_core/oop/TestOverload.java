package com.mercury.java_core.oop;

// overload is part of polymorphism
public class TestOverload {
	
//	static void test() {
//
//	}

	void test() {

	}
	
	void test(int x) {
		System.out.println("int");
	}
	
	// overload doesn't apply to return type
//	int test(int x) {
//		return 0;
//	}
	
	void test(String x, int y) {
		
	}
	
	void test(Integer x) {
		System.out.println("Integer");
	}
	
	void test(byte x) {
		System.out.println("byte");
	}
	
	void test(long x) {
		System.out.println("long");
	}
	
	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		long l = 1;
		byte b = 1;
		// int > byte, int > long, Integer > byte
		to.test(1);
		to.test(l); // long (8 byte, 64 bit) cannot fit int (32 bit)
		to.test(b); // bit (8 bit) can fit int
		// b cannot fit Integer, cannot Boxing, Box must match
	}
	
}
