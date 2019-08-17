package com.mercury.java_core.thread;

// only one instance may be created using this class.
public class MySingleton {
	// 1. eager initialization singleton: 最开始就创建
//	private static MySingleton instance = new MySingleton();
	
	// 2. lazy initialization: 创建了也没什么人用的感觉
	private static MySingleton instance;
	
	private MySingleton() { // private important!!!
		
	}
	
	public static MySingleton getInstance() {
//		return instance; // 1.
		
		// 2. 保证只有一个
//		if (instance == null) {
//			instance = new MySingleton();
//		}
//		return instance;
		
		// 3. multi-threading
//		synchronized (MySingleton.class) {
//			if (instance == null) {
//				instance = new MySingleton();
//			}
//		}
		
		// 4. double-checking pattern 重要
		if (instance == null) {
			synchronized (MySingleton.class) {
				if (instance == null) {
					instance = new MySingleton();
				}
			}
		}
		
		return instance;
	}
	
}
