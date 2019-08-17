package com.mercury.java_core.midterm;

import java.util.Arrays;

public class TestCard {

	public static void main(String[] args) {
		Card c1 = new Card(5, "red");
		Card c2 = new Card(10, "yellow");
		Card c3 = new Card(15, "green");
		Card c4 = new Card(15, "green");
		Card c5 = new Card(15, "white");
		
		Card[] cards = {c1, c2, c3, c4, c5};
		
		String[] myCards = Arrays.stream(cards)
				.distinct()
				.sorted((o1, o2) -> (c1.getNumber() - c2.getNumber()))
				.filter(c -> c.getColor().equals("red"))
				.map(c -> c.getNumber() + " - " + c.getColor())
				.toArray(size -> new String[size]);
		
		System.out.println(Arrays.toString(myCards));
	}

}
