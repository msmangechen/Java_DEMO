package com.mercury.java_core.inner_class;

public class TestInnerClass {

	public static void main(String[] args) {
		// use static inner class
		Outer.StaticInner si = new Outer.StaticInner();
		Outer outer = new Outer();
		Outer.NonStaticInner nsi = outer.new NonStaticInner();

		// MIDTERM
		// Anonymous Inner class: extend a class or implement an interface.
		// create only once, then destroy
		// can only use final or effectively final instance
		Bag bag = new Bag() {
			static final int x = 1;
			int y = 1;

			@Override
			void carry() {
				System.out.println("Handbag is carry...");
			}

		}; // abstract class cannot be instantiate
		bag.carry();
		// interface: cannot create instance.
		// create instance which implements interface
		Carryable c = new Carryable() {

			@Override
			public void carry() {
				System.out.println("I can carry you.");
			}

		};
		// c is instance of Carryable, not created by Carryable, is created by anonymous
		// class
		// $2 means the second anonymous innerclass
		System.out.println(c.getClass()); // class com.mercury.java_core.inner_class.TestInnerClass$2
	}

}
