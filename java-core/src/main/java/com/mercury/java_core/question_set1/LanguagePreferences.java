package com.mercury.java_core.question_set1;

public class LanguagePreferences {
	enum Color {RED, GREEN, YELLOW};

	public static void main(String[] args) {
		// Q1: difference between & and &&
//		int x = 1;
//		boolean b = false;
//		if (b & (x++) > 0) {
//			System.out.println("error");
//		} else {
//			System.out.println(x);
//		}
		
		// Q2: = and ==
//		int x = 1;
//		boolean b = false;
//		if (x = 5) {}
//		if (b = true) {}
		
		// Q3: switch and default
//		int x = 1; // int x = 5; short x = 5
//		switch (x) {
//			default: System.out.println("Z");
//			case 1: System.out.println("A");
//			case 2: System.out.println("B");
//			case 3: System.out.println("C");
//		}
		
		// Q4: switch for enum type
		
		Color color = Color.RED;
		switch (color) {
			case RED: System.out.println("A");
			case GREEN: System.out.println("B");
			case YELLOW: System.out.println("C");
		}
		
	}
	
}
