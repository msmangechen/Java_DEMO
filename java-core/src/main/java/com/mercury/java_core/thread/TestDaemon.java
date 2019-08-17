package com.mercury.java_core.thread;

// 永远不会停
public class TestDaemon {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			int i = 0;
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
				i++;
			}
		});
		t.setDaemon(true); // 主线程停止，就会停
		t.start();
		
		// 主线程5s后结束
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main is done.");
	}

}
