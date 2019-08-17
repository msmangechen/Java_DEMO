package com.mercury.java_core.question_set1;

public class TestAccessibility {

//	static final int[] a = {100, 200};
//	static final int[] a;
//	static {a=new int[2]; a[0]=100; a[1]=200;} // static block
//	static final int[] a = new int[2] {100, 200};
//	static final int[] a;
//	static void init() { // static method
//		a = new int[2];
//		a[0] = 100;
//		a[1] = 200;
//	}
	
	public static void main(String[] args) {

	}

}

abstract class Employee {
	abstract double getSalesAmount();
}
class Sales extends Employee {
	public double getSalesAmount() {
		return 1;
	}
	
	public double getCommission() {
		return getSalesAmount() * 0.15;
	}
}
class Foo {
	static void alpha() {
		Foo.alpha();
//		beta();
	}
	void beta() {
//		Foo.beta();
		alpha();
	}
}
