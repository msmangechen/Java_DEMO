package com.mercury.java_core.question_set1;

public class TestString {
	
	static void foo(String str) {
		str = "inFoo";
	}
	
	public static void main(String[] args) {
		// Q5: How many objects are created?
		String s = "abc";
		s = s + "defgh";
		s = s.substring(2, 6);
		s = s.toUpperCase();
		s = s.toString();
		
		// Q6: What is the output?
		String str = "abc";
		foo(str);
		System.out.println(str);
		
		// Q7: What is the output?
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = "abc";
//		String s4 = "abc;
		System.out.println(s1 == s2); // false
		System.out.println(s2 == s3); // false
//		System.out.println(s3 == s4);
		System.out.println(s1.intern() == s2.intern()); // true
		System.out.println(s1.intern() == s3.intern()); // true
	}
	
}
