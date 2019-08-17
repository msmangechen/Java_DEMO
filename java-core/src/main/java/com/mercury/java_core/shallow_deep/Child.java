package com.mercury.java_core.shallow_deep;

public class Child implements Cloneable {
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
