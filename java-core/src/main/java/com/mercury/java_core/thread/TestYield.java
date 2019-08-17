package com.mercury.java_core.thread;

// low priority线程，调用yield表示不着急被调用，让别的先调用，舔狗不能guarantee
public class TestYield {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0) {
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(i);
					Thread.yield(); // 没有的话且时间片没有用完，会继续打印
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 == 0) {
//					try {
//						Thread.sleep(501);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(i);
					Thread.yield();
				}
			}
		});
		t1.start();
		t2.start();
	}

}
