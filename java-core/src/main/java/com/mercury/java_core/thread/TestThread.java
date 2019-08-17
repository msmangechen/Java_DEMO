package com.mercury.java_core.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread {

	public static void main(String[] args) {
		// two threads: main thread, GC thread(daemon thread, lowest priority)
		System.out.println(Thread.currentThread().getName() + " is running.(Main)");
		
		// how to create Thread?
		// 1. create a class extends Thread class
		Thread t1 = new MyThread1();
		// 在哪里创建了这个方法，哪里就是current Thread
		t1.start(); // create a new Thread and execute run in that Thread
//		t1.start(); // one thread start once
		// 在哪里调用了这个方法，哪里就是它的current Thread
		t1.run(); // not create a new Thread, it will execute run in current thread(main).
		// 执行顺序和分布的时间片有关系，时间片是不一定的，所以顺序不确定
		
		// 2. create a class implements Runnable interface.
		Runnable r2 = new MyThread2(); // 没有start()
		Thread t2 = new Thread(r2);
		t2.start();
		
		Thread t3 = new Thread(
			() -> System.out.println(Thread.currentThread().getName() + " is running. (t3)")
		);
		t3.start();
		
		// 3. use Callable: create a thread which returns data back.
		// Runnable return nothing, Callable return data
		Callable<Integer> c4 = new MyThread3();
		// ThreadPool
		ExecutorService es = Executors.newSingleThreadExecutor(); // 单核单线程
		// Java has blocking
		// Future<>: 从Callable拿到返回值
		Future<Integer> future = es.submit(c4); // execute() take Runnable
		try {
			Integer result = future.get(); // 在future返回之前会block当前thread
			System.out.println("main is done." + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
