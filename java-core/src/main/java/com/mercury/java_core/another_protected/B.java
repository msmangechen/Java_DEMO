package com.mercury.java_core.another_protected;

import com.mercury.java_core.test_protected.A;

public class B extends A{

	void test() {
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.x);
		C c = new C();
		System.out.println(c.x);
	}
	
}
