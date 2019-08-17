package com.mercury.java_core.thread;

import java.util.Arrays;

public class MyList {
	
	int[] table = new int[1];
	int size = 0;
	
	// 下面两个的缺点：所有的list（比如有l1，l2）都会逐个执行，我们希望可以l1 l2各自逐个执行
	// synchronized: protect
//	public static synchronized void add(int x) {
//		// 没有synchronized，work in single thread mode, not in multi-thread mode，并不thread safe
//		// 两个都做同时去使用table，时间片短，两个都会看if，都以为是size 0，都没有执行resize，那么久会OutOfBound
//		// Error: ArrayIndexOutOfBoundsException
//		if (size >= table.length) {
//			// 省略copy原本的data到新的
//			table = Arrays.copyOf(table, size << 1);
//		}
//		table[size++] = x;
//	}
	
	// 等同于上面的，更flexible，
//	public static void add(int x) {
//		// protect, MyList.class相当于lock
//		synchronized (MyList.class) { // class monitor(class-level lock)
//			if (size >= table.length) {
//				table = Arrays.copyOf(table, size << 1);
//			}
//
//			table[size++] = x;
//		}
//	}
	
	// l1 l2各自逐个执行
//	public synchronized void add(int x) {
//		if (size >= table.length) {
//			table = Arrays.copyOf(table, size << 1);
//		}
//
//		table[size++] = x;
//	}
	
	// 等同于上面的
	public void add(int x) {
		synchronized (this) { // instance monitor(object level lock)
			if (size >= table.length) {
				table = Arrays.copyOf(table, size << 1);
			}

			table[size++] = x;
		}
	}
	
}
