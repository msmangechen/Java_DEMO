package com.mercury.java_core.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
		Thread producer = new Thread(new Producer(bq));
		producer.start();
		
//		Thread consumer1 = new Thread(new Consumer(bq));
//		consumer1.start();
//		Thread consumer2 = new Thread(new Consumer(bq));
//		consumer2.start();
//		Thread consumer3 = new Thread(new Consumer(bq));
//		consumer3.start();
		
		// Thread pool
//		ExecutorService pool = Executors.newFixedThreadPool(5); // pool里最多10个线程
		ExecutorService pool = Executors.newCachedThreadPool(); // 没有大小限制，可能会创建20个thread
		for (int i = 0; i < 20; i++) {
			Consumer c = new Consumer(bq);
			pool.execute(c);
		}
//		Hashtable
//		ConcurrentHashMap
	}

}
