package com.mercury.java_core.oop;

public abstract class Bird implements Flyable {
	
	static int x = 1; // 可以有static
	abstract void eat();
	
//	cannot instantiate lie new Bird()
	Bird() {
		
	}
	
	void walk() {
		System.out.println("Bird is walking!");
	}

	public void fly() {
		System.out.println("Bird is flying");
	}
}
