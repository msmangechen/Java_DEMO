package com.mercury.java_core.java8.interfaces;

public class Basketball implements Playable, Rollable{
	
	final int x = 0;
	final int y;
	static final int z;
	String s; // null
	
	// static block to instantiate z, only way
	static {
		z = 2;
	}
	
	// have y in constructor
	Basketball() {
		y = 1;
	}

	@Override
	public void play() {
		
	}

	@Override
	public void roll() {
		
	}
	
//  Both Playable and Rollable have test2(), Java force use to override the method	
//	solve Diamond problem
	public void test2() {
		System.out.println("test2 in Basketball!");
	}

}
