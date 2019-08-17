package com.mercury.java_core.oop;

public class TestCasting {

	public static void main(String[] args) {
		Child c = new Child();
		
		AnotherChild ac = new AnotherChild("");
		
		// Child is a instance of Parent, fields and static methods
		// reference type: Parent, fields and static methods
		// actual type: Child, instance method(override)
		// upcasting: convert Child to Parent
		Parent c1 = new Child();
		// 只能访问parent下面的method，c1不能访问Child的method
		// 比如LinkedList和ArrayList
		c1.printT(); // print t in Child
		System.out.println(c1.t); // Parent t
		System.out.println(c1.q);
		c1.printStatic();
		
		c1 = new AnotherChild("");
		c1.printT(); // print t in AnotherChild
		// method 有 override, but property 没有 override
		// property depends on reference type, method depends on actual type. 
		System.out.println(c1.t);
		System.out.println(c1.q);
		// static method can't be override, it can be redeclared (in Child/AnotherChild)
		// instance method depends on instance(actual type)
		c1.printStatic();
		
		// downcasting: convert Parent to Child
		// requires manual casting
		// ClassCastException: happens when we want to downcast AnotherChild to Child
//		Child c2 = (Child) c1;
	}

}
