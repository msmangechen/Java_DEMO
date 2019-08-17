package com.mercury.java_core.io;

import java.io.Serializable;

public class Parent {

//	protected static final long serialVersionUID = 1L;
	
	String name;
	int age;
	
	@Override
	public String toString() {
		return "Parent [name=" + name + ", age=" + age + "]";
	}

	public Parent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
