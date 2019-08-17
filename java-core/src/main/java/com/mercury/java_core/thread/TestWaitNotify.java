package com.mercury.java_core.thread;

public class TestWaitNotify {

	public static void main(String[] args) {
		final Object lock = new Object();
		
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				synchronized (lock) {
					if (i % 2 != 0) {
						System.out.println(i);
					}
					// 进入wait，释放lock
					try {
						lock.notify(); // notify will wake up any waiting thread of the same lock
						lock.wait(); // release lock and put current thread into waiting pool to wait for this lock.
						// 不能在wait后面notify，因为有两个wait，会随机notify一个
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				synchronized (lock) {
					if (i % 2 == 0) {
						System.out.println(i);
					}
					try {
						lock.notify();
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
	}

}
