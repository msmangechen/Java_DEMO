package com.mercury.java_core.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
	
//	static int count = 0;
	// 原本不一定会output 99999，加了AtomicInteger一定是99999
	static AtomicInteger ai = new AtomicInteger(0); // Interview

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				if (ai.incrementAndGet() == 99) { // incrementAndGet: add 1 and get the number
					System.out.println(99);
				}
			}).start();
		}
		Thread.sleep(100);
	}

}
