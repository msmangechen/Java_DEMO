package com.mercury.java_core.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestO3 {

	public static void main(String[] args) {
		Data data = new Data(2, "def");
		try (FileOutputStream fos = new FileOutputStream("files/test3.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos); // decorator
		) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
