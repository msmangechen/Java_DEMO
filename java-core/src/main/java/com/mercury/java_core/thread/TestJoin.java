package com.mercury.java_core.thread;

public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello!");
		});
		t.start();
		// keep "main end" after t
		t.join(); // main thread calls t.join(), main will wait for t finishes
		System.out.println("main end");
	}

}
