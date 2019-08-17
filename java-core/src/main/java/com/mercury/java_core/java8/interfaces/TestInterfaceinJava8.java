package com.mercury.java_core.java8.interfaces;

public class TestInterfaceinJava8 {

	public static void main(String[] args) {
		Playable.test1(); // static void method

		Basketball b = new Basketball();
		// b.test1();

		b.test2(); // use default method, must have instance and concrete class
	}

}
