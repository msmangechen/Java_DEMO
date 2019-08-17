package com.mercury.java_core.oop;

public class Child extends Parent {
	
	static int x = 1; // static: class level, shared by all instance, eg. c1, c2
	int y = 2; // non-static: object level, used by class name or instance name, has its own
	int t1 = 1;
	int t = -1;
	static int q = -1;

	// non-static cannot be used in static variable/function
	static { // static block
		x = -1;
		System.out.println("static block");
	}
	
	// static can be used in non-static variable/function
	{
		y = -2;
		x = 0;
		System.out.println("non-static block");
	}
	
	Child() {
		// automatically invoke Parent() method by using super();
		super("");
		System.out.println("Child");
	}
	
	public String toString() {
		// override accessor must be >= the original accessor
		return "x: " + x + ", y: " + y;
	}
	
	void printT1() {
		System.out.println("t1 in Child: " + t1);
	}
	
	void printT() {
		System.out.println("t in Child: " + t);
		System.out.println("q in Child: " + q);
	}
	
	public static void main(String[] args) {
		
		// non-static
		Child c1 = new Child();
		Child c2 = new Child();
		System.out.println(c1.y);
		System.out.println(c2.y);
		c1.y = 3;
		System.out.println(c1.y); // 3
		System.out.println(c2.y); // 2
		
		// static: 
		System.out.println(Child.x);
		System.out.println(c1.x);
		System.out.println(c2.x);
		c1.x = 4;
		System.out.println(c2.x); // 4
		
		System.out.println(c1); // find c1 in Object class
	}
	
	static void printStatic() {
		System.out.println("static in Child");
	}
	
}
