package com.mercury.java_core.thread;

public class TestLock {
	
	static int x = 0;

	public static void main(String[] args) {
		final Object lock = new Object(); // lock must be final
		// t1或t2都有可能先执行，跟sleep的时间没有关系
		// 先拿到时间片的执行，第二个会等待第一个执行完成后释放lock，再执行
		Thread t1 = new Thread(() -> {
			// synchronized block
			synchronized(lock) { // synchronized：代码执行时占用锁, synchronized only take object
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000); // 自动醒，不需要唤醒（notify）
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t1: " + x++);
				}
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized(lock) { // 如果没有就不会等，如果有会等待上面的锁释放
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2: " + x);
			}
		});
		t1.start();
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t2.start();
	}
	
}
