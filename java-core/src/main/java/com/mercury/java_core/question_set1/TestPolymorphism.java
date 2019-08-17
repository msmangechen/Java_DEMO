package com.mercury.java_core.question_set1;

public class TestPolymorphism {

	public static void main(String[] args) {
//		BaseP b = new SubP();
//		b.foo1();
//		b.foo2();
//		
//		BaseP b = new SubP();
		
//		Three t3 = new Three();
//		t3.foo();
		
	}
}

//class BaseP {
//	static void foo1() { // static cannot be override
//		System.out.println("foo1 in Base");
//	}
//	void foo2() {
//		System.out.println("foo12 in Base");
//	}
//	
//	int x = 3;
//	private void foo() {
//		System.out.println(x + " in Base");
//	}
//	BaseP() {
//		foo();
//	}
//}
//
//class SubP extends BaseP {
//	static void foo1() {
//		System.out.println("foo1 in Sub");
//	}
//	void foo2() {
//		System.out.println("foo2 in Sub");
//	}
//	
//	int x = 5;
//	public void foo() {
//		System.out.println(x + " in Sub");
//	}
//	SubP() {
//		foo();
//	}
//}

//class One {
//	public One foo() {
//		return this;
//	}
//}
//class Two extends One {
//	public One foo() {
//		return this;
//	}
//}
//class Three extends Two {
//	public One foo() {
//		return this;
//	}
//}

//class Plant {
//	String name;
//	public Plant() {
//		this("elm");
//	}
//	public Plant(String name) {
//		this.name = name;
//	}
//	public String getName() {
//		return name;
//	}
//}
//
//class Tree extends Plant {
//	
//	public void growFruit() {}
//	public void dropLeaves() {}
//}