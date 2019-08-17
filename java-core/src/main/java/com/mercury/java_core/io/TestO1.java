package com.mercury.java_core.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestO1 {

	public static void main(String[] args) {
		// -1: 11111111 11111111 11111111 11111111  (取反加一)
		// 写入byte只会有11111111，就是255
		int[] nums = {-1, 2, 3, 4, 1234567};
		
		// < Java 1.7
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream("files/test1.txt");
//			for (int x : nums) {
//				fos.write(x);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) { // disk is full can't be written
//			e.printStackTrace();
//		} finally {
//			if (fos != null) { // avoid null exception
//				try { // 如果被人删了，就需要try catch
//					fos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} // release, let others use this file
//			}
//		}
		
		// >= Java 1.7, try-with resource
		// AutoCloseable: close resource automatically
		// close() before catch and finally
		// if close() has exception, what will happen?
		try (
				FileOutputStream fos = new FileOutputStream("files/test1.txt");
				Door door = new Door();
		) {
			for (int x : nums) {
				fos.write(x);
			}
//			throw new RuntimeException();
		} catch (IOException e) {
			System.err.println(e);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("catch!");
		} finally {
			System.out.println("done!");
		}
	}
	
}
