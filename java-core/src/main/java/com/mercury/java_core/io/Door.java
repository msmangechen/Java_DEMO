package com.mercury.java_core.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Door implements AutoCloseable {

//	@Override
//	public void close() throws Exception {
//		try {
//			System.out.println("Door is closing!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// override: unchecked exception don't need to follow the rule
	// but check exception must be "is a" relationship
	@Override
	public void close() throws Exception { // cannot be Throwable, Throwable is not Exception
		System.out.println("Door is closing!");
	}
	
}
