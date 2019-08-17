package com.mercury.java_core.thread;

// Runnable better than MyThread1
// more flexible, because it sill can extends other class
// 强制要求override run()，确认是override而不是overload
// lambda function更方便
public class MyThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running. (Thread2)");
	}

}
