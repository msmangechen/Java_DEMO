package com.mercury.java_core.io;

import java.io.FileInputStream;
import java.io.IOException;

public class TestR1 {

	public static void main(String[] args) {
		// FileInputStream read in byte, so only read the last 8 digit
		try (FileInputStream fis = new FileInputStream("files/test1.txt")) {
			int x = fis.read();
			while (x != -1) {
				System.out.println(x);
				x = fis.read(); // 写入文件是不正确的数字：255 2 3 4 135
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
