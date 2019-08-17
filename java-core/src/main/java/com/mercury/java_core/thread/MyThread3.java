package com.mercury.java_core.thread;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable<Integer> {
	
	@Override
	public Integer call() { // checked exception, 这里不需要throw exception？？
		System.out.println("MyThread 3 is going to sleep.");
		try {
			Thread.sleep(2000); // 睡眠时不会被CPU分配时间, blocking
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyThread 3 is awake after 2 seconds.");
		return 666;
	}

}
