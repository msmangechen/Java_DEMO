package com.mercury.java_core.oop;

public class TestCloneable {

	public static void main(String[] args) throws CloneNotSupportedException {
		User user = new User("bob", 21);
		// clone in (protected) Object class (in package java.lang)
		User clone = user.clone();
		System.out.println(clone.name);
	}
	// throw: 到了main再往上扔锅，给JVM handle

}
