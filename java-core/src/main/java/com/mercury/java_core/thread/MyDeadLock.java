package com.mercury.java_core.thread;

public class MyDeadLock {
	public static Object l1 = new Object();
	public static Object l2 = new Object();

	private static class Thread1 extends Thread {
		public void run() {
			synchronized(l1) {
				System.out.println("Thread1: Holding lock 1...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: Waiting for lock 2...");
				
				synchronized(l2) {
					System.out.println("Thread1: Holding lock 1 and 2...");
				}
			}
		}
	}
	
	private static class Thread2 extends Thread {
		public void run() {
			synchronized(l2) {
				System.out.println("Thread2: Holding lock 2...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: Waiting for lock 1...");
				synchronized(l1) {
					System.out.println("Thread2: Holding lock 1 and 2...");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}
}