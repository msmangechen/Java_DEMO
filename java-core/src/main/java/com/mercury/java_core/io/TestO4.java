package com.mercury.java_core.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// Externalizable：决定读哪些，有选择的读和写
public class TestO4 {

	public static void main(String[] args) {
		try (
				FileOutputStream fos = new FileOutputStream("files/test4.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			Account account = new Account("Bob", "123456");
			oos.writeObject(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
