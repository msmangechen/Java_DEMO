package com.mercury.java_core.thread;

// Apple面试题
// Enum instance created by JVM
public enum MyEnum {

	East(1), West(2), South(3), North(4); // 4个instance

	private int order;

	MyEnum(int order) { // Enum的constructor默认private
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
