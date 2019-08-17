package com.mercury.java_core.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestR4 {

	public static void main(String[] args) {
		
		try (
				FileInputStream fis = new FileInputStream("files/test4.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			Account account = (Account) ois.readObject();
			System.out.println(account);
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
