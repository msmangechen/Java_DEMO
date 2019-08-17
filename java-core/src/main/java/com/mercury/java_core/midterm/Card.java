package com.mercury.java_core.midterm;

import java.io.Serializable;

import com.mercury.java_core.oop.User;

public final class Card implements Cloneable, Comparable<Card>, Serializable {

	private int number;
	private String color;

	public Card(int number, String color) {
		super();
		this.number = number;
		this.color = color;
	}
	
	public int getNumber() {
		return number;
	}

	public String getColor() {
		return color;
	}

	@Override
	public int compareTo(Card o) {
		int result = number - o.getNumber();
		if (result == 0) {
			return color.compareTo(o.getColor());
		} else {
			return result;
		}
	}
	
	public Card clone() throws CloneNotSupportedException {
		return (Card) super.clone();
	}

	@Override
	public int hashCode() {
 		return number + color.hashCode() * 31;
	}

	@Override
	public String toString() {
		return "Card [number=" + number + ", color=" + color + "]";
	}
	
}
