//package com.mercury.java_core.question_set1;
//
//public class TestCasting {
//	
//	void foo(Short x) {
//		System.out.println("Short: " + x);
//	}
//	
//	static void foo(Long x) {
//		System.out.println("Long: " + x);
//	}
//	
//	static void foo(int x) {
//		System.out.println("Int: " + x);
//	}
//	
//	
//	public static void main(String[] args) {
//		// Q8: What is the output?
//		short x = 6;
//		long y = 7;
//		foo(x);
//		foo(y);
//		
//		// Q9: What is the output?
//		new A().foo("abc");
//		new A().foo(null);
//		
//		// Q10: What is the output?
//		A a = new A();
//		a.doIt(3, 4);
//		a.doIt(5);
//		a.doIt(6, 7, 8);
//	}
//}
//
//class A {
//	void foo(Object o) {
//		System.out.println("Object");
//	}
//	void foo(String str) {
//		System.out.println(str);
//	}
//	
//	public void doIt(int x, int y) {
//		System.out.println("a");
//	}
//	public void doIt(int ... vals) { // New feature in Java 5
//		System.out.println("b");
//	}
//}
//
