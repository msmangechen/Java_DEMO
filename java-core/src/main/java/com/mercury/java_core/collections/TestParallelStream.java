package com.mercury.java_core.collections;

import java.util.ArrayList;
import java.util.List;

public class TestParallelStream {

	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		for (long i = 0; i < 1000; i++) {
			list.add(i);
		}
		
		long startTime = System.currentTimeMillis();
		System.out.println(
			list.stream().reduce(0l, (a, b) -> {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return a + b;
			})
		);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime) + "ms");
		
		// 等同于上面，唯一不同是用了parallel stream：把所有数据分别放到不同threads
		startTime = System.currentTimeMillis();
		System.out.println(
			// forkAndJoin: 4core * 1= 4threads
			list.parallelStream().reduce(0l, (a, b) -> {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return a + b;
			})
		);
		endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime) + "ms");
	}
	
}
