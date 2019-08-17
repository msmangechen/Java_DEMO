package com.mercury.java_core.oop;

import java.util.ArrayList;
import java.util.List;

public class TestAddress {

	public static void main(String[] args) {
		List<Integer> mb = new ArrayList<Integer>();
		mb.add(1);
		Address msi = new Address("5 Independency Way", "Princeton", "NJ", mb);
		System.out.println(msi.getMailBoxes().add(2));
	}
	
}
