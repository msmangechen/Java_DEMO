package com.mercury.java_core.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestR3 {

	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("files/test3.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			Data data = (Data) ois.readObject();
			System.out.println(data);
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
