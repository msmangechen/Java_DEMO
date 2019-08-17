package com.mercury.java_core.test_exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestOverrideException {
	
	class A {
//		public void test() {
//			
//		}
		
//		public void test() throws RuntimeException {
//			
//		}
		
		public void test() throws IOException {
			
		}
	}
	
	class B extends A {
//		@Override // annotation
//		public void test() throws RuntimeException {
//			
//		}
		
//		@Override
//		public void test() throws  {
//			
//		}
		
		@Override
		public void test() throws FileNotFoundException { // CloneNotSupportedException Error
			
		}
	}
	
	// 1.
	// parent no exception, child can't throws checked exception (eg. IOException)
	// but can throw unchecked exception (eg. RuntimeException)
	
	// 2.
	// parent throws unchecked exception, child can't throw checked exception
	// but can throw ANY unchecked exception
	
	// 3.
	// parent throws checked exception
	// a. child can throw ANY unchecked exception or doesn't throw ANY exception
	// b. if child throws checked exception, that exception must be a child class
	// of parent's checked exception("is-a").

}
