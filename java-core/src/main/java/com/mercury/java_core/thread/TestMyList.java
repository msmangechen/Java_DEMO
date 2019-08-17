package com.mercury.java_core.thread;

import java.util.Arrays;

public class TestMyList {

	public static void main(String[] args) {
		final MyList list = new MyList();
//		System.out.println(list.getClass() == MyList.class);
		Thread t1 = new Thread(() -> {
			list.add(500);
		});
		Thread t2 = new Thread(() -> {
			list.add(1000);
		});
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 结果：500 1000 或 1000 500
		Arrays.stream(list.table).forEach(i -> System.out.println(i));
	}

}
