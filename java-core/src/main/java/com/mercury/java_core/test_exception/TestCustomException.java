package com.mercury.java_core.test_exception;

public class TestCustomException {
	
	static void test1() throws CustomCheckedException { // Exception here can be itself and its Parent Exception
		throw new CustomCheckedException("Hi"); // must handle
	}
	// throw vs throws
	// throws: handle exception
	// throw: create exception
	
	static void test2() {
		throw new CustomUncheckedException("Hello"); // 不需要handle
	}
	
	public static void main(String[] args) {
		
//		try must come with either catch or finally
		try {
			test1();
			test2();
		} catch(CustomCheckedException e) {
			System.err.println(e);
		} catch(CustomUncheckedException e) { // parent class都可以
			System.err.println(e);
//			e.printStackTrace(); // print all stack trace
			e = null; // use for GC
		} finally { // always execute no matter we have exception or not
			System.out.println("will always be executed whether there is exception or not");
		}
		
//		try {
//			test1();
//			test2();
//		} catch(Exception e) {
//			System.err.println(e.getMessage());
//		} catch(CustomCheckedException e) { // ERROR: not reachable 父类必须在子类后面
//			System.err.println(e.getMessage());
//		} finally {
//			System.out.println("will always be executed whether there is exception or not");
//		}
		
		try {
			test1();
			test2();
		} catch(CustomCheckedException | CustomUncheckedException e) { // 这个格式only >= 1.7
			System.err.println(e);
//			e = null; // error: multi-catch block not allow to reassign exception
		} finally {
			System.out.println("will always be executed whether there is exception or not");
		}
		
	}

}
