 package com.mercury.java_core.string_pool;

public class TestStringPool {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);

		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s3 == s4);

		System.out.println(s1 == s3);

		String s5 = new String("def"); // create 2 objects in Heap and String pool
		String s6 = "def"; // { 'd', 'e', 'f' }
		System.out.println(s5.intern() == s6); // true
		System.out.println(s5.intern() == s5); // false, not in the String Pool
		System.out.println(s6.intern() == s6); // true, in the String Pool

		// String is immutable

		StringBuilder sb = new StringBuilder("abc");
		sb.setCharAt(1, 'd');
		System.out.println(sb.toString());
		// StringBuffer is thread-safe: only one thread can work on this thread
		// 不能有两个user同时make change
		StringBuffer sbf = new StringBuffer("def");

		
		// t1 t2 t3: String pool 3个
		// t3: String pool 3个
		// t1 t2 t3 t4: String pool 4个
		String t1 = "abc";
		String t2 = "def";
		String t3 = "abc" + "def";
		String t4 = t3.substring(1); // 在Heap上创建了object，string pool中没有
		
	}

}
