package com.mercury.java_core.oop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {

	// inspect class during the runtime in JVM
	// Reflection API
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Parent c1 = new Child();
		System.out.println(c1.getClass());
		Class<?> clazz = c1.getClass(); // Child class
		System.out.println(clazz.getSuperclass());
		System.out.println(Arrays.asList(clazz.getDeclaredFields()));
		System.out.println(Arrays.asList(clazz.getMethods()));
		
		// class的引用，class也是一个对象
		try {
			// 加载别的library的class
			Class childClass = Class.forName("com.mercury.java_core.oop.Child");
			System.out.println(childClass.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// use reflection to create a new instance
		try {
			Child c2 = (Child)clazz.newInstance(); // new Class的另一个方法
			System.out.println(c2);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// use Reflection to invoke private method 
		User u = new User("Alex", 20);
		try {
			Method method = u.getClass().getDeclaredMethod("hi");
			method.setAccessible(true);
			method.invoke(u);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// make String to be mutable
		String s1 = "abc";
		System.out.println(s1); // abc
		System.out.println(s1.hashCode());
		
		Field value = s1.getClass().getDeclaredField("value");
		value.setAccessible(true);
		value.set(s1, "defe".toCharArray());
		
		System.out.println("abc"); // def
		System.out.println(s1.hashCode());
	}
	
}
