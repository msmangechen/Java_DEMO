package com.mercury.java_core.thread;

public class MyThread1 extends Thread {
	
	@Override
	public void run() {
		// each thread has name assigned by Java, output the name of current Thread
		System.out.println(Thread.currentThread().getName() + " is running. (Thread1)"); 
	}
	
}
