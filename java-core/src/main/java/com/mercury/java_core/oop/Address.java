package com.mercury.java_core.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// immutable class
public final class Address {

	private String street;
	private String city;
	private String state;
	private List<Integer> mailBoxes;

	public Address(String street, String city, String state, List<Integer> mailBoxes) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.mailBoxes = Collections.unmodifiableList(mailBoxes); // 重要，list内部不能被更改
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public List<Integer> getMailBoxes() {
		return mailBoxes;
	}

}
