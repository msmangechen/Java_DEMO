package com.mercury.java_core.question_set1;

public class TestConstructor {

	public static void main(String[] args) {
		// Q11: What is the output?
//		Base b = new Sub();
		
		// Q12: What is the output?
//		Base b = new Sub("Go");
		
		// Q13: overloaded constructors
		Boot b = new Boot();
		System.out.println(b.boot + " " + b.foot);
	}

}

class Base {
	Base() {
		System.out.println("Base");
	}
	Base(String str) {
		System.out.println(str + " in Base");
	}
}

class Sub extends Base {
//	Sub() {
//		System.out.println("Sub");
//	}
	Sub(String str) {
		System.out.println(str + " in Sub");
	}
}

class Boot {
	int boot;
	String foot;
	public Boot() {
		this("foot");
		System.out.println("first");
	}
	public Boot(String foot) {
		this(420, foot);
		System.out.println("second");
	}
	public Boot(int boot, String foot) {
		this.boot = boot;
		this.foot = foot;
		System.out.println("third");
	}
}