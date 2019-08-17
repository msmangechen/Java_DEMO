package com.mercury.java_core.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer> bq;
	
	Producer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
				bq.put(i);
				System.out.println("Producer " + Thread.currentThread().getName() + " produces: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
