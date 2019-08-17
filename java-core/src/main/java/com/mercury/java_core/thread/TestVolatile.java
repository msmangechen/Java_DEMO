package com.mercury.java_core.thread;

public class TestVolatile {
	// 所有volatile的变量都是从主内存读，不管是读或写，都绕过了CPU的cache
	private static volatile int num = 0;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println("t1 executes.");
			while (true) { // 用完了时间片进入ready
				if (num >= 5) { // cannot see the latest update of number
					break;
				}
			}
			System.out.println(num + " in t1."); // 这条line后面就进入dead
		});
		Thread t2 = new Thread(() -> {
			while (num < 10) {
				num++;
				System.out.println(num + " in t2.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
	
}
