package com.mercury.java_core.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestR2 {
	
	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("files/test2.txt");
				BufferedInputStream bis = new BufferedInputStream(fis); // 在内存读，速度快
				DataInputStream dis = new DataInputStream(fis); // Decorator
		) {
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
		} catch (IOException e) {
			
		}
	}
	
}
