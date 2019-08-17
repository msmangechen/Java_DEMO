package com.mercury.java_core.collections;

// 必须要加@FunctionalInterface，才可以在functional interface使用
@FunctionalInterface
public interface Testable {

	void test(); // abstract method
//	void test2(); // functional interface 只能有一个抽象方法
	
//	static/default必须要有实现 
	static void test1() {
		
	}
	default void test2() {
		
	}
	
	int hashCode(); // Object下面的方法，会被skip，不能用lambda override
}
