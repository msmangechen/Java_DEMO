package com.mercury.java_core.inner_class;

public abstract class Bag {

	String brand = "No Brand";
	
	abstract void carry();
	
	public void printBrand() {
		System.out.println(brand);
	}
	
}
