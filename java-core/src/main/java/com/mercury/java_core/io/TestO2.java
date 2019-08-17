package com.mercury.java_core.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestO2 {

	public static void main(String[] args) {
		try (
				FileOutputStream fos = new FileOutputStream("files/test2.txt"); // write in test2.txt
				DataOutputStream dos = new DataOutputStream(fos); // whatever I write will send to fos
		) {
			int x = -1;
			double y = 3.14;
			boolean b = true;
			dos.writeInt(x); // write in int(4 byte)
			dos.writeDouble(y); // write in double(8 byte)
			dos.writeBoolean(b); // write in boolean
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
