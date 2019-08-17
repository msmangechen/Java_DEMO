package com.mercury.java_core.thread;

public class TestThreadLocal {
	
	static class Test {
		int x; // 被所有thread共享
		
		// 让每个thread都有自己的y，不会印象到static Test
		// 用anonymous方法来定义初始值
		ThreadLocal<Integer> y = new ThreadLocal<Integer>() {

			@Override
			protected Integer initialValue() {
				return 10;
			}
			
		};
	}
	
	static class MyLocalThread extends Thread {
		
		Test test;
		
		MyLocalThread(Test test) {
			this.test = test;
		}
		
		public void run() {
			test.x++;
			System.out.println(Thread.currentThread().getName() + ": x - " + test.x);
			
			test.y.set(test.y.get() + 1);
			System.out.println(Thread.currentThread().getName() + ": y - " + test.y.get());
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		new MyLocalThread(t).start();
		new MyLocalThread(t).start();
	}

}
