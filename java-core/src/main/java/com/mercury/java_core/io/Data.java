package com.mercury.java_core.io;

import java.io.Serializable;

// Serializable: marker interface(内部没有实现)
// must tell JVM it's Serializable, JVM会告诉Java Data的变化
// Java在TestR3会扔出exception，版本号有问题（Data和TestO3的版本号不同）
public class Data implements Serializable {

	private static final long serialVersionUID = 666;
	
//	static int x = 1; // static cannot be serialized. because it belongs to class, not object
	transient int x = 1; // modifier, will not be written into file, x will be 0, not serializable
	String y = "abc";
	
	public Data(int x, String y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Data [x=" + x + ", y=" + y + "]";
	}
	
}
