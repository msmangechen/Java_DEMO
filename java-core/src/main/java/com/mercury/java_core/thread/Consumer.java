package com.mercury.java_core.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	BlockingQueue bq;
	
	Consumer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
				Integer data = (Integer) bq.take();
				System.out.println("Consumer " + Thread.currentThread().getName() + " consumers: " + data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
