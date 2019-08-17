package com.mercury.java_core.thread;

// 重要
// 请求锁的顺序相反容易出现死锁，如果顺序相同就可以避免死锁，可以使用ReentrantLock
public class TestDeadLock {
	private static class Friend {
		String name;

		public Friend(String name) {
			this.name = name;
		}

		// lock who call synchronized (eg.alice.bow() is alice)
		public synchronized void bow(Friend another) {
			System.out.println(name + " bows to " + another.name);
			another.bowBack(this);
		}

		public synchronized void bowBack(Friend another) {
			System.out.println(name + " bows back to " + another.name);
		}
	}

	public static void main(String[] args) throws Exception {
		Friend alice = new Friend("Alice");
		Friend bob = new Friend("Bob");
		Thread r1 = new Thread() {
			@Override
			public void run() {
				alice.bow(bob);
			}
		};
		Thread r2 = new Thread() {
			@Override
			public void run() {
				bob.bow(alice);
			}
		};
		r1.start();
		r2.start();
		r1.join();
		r2.join();
		System.out.println("End of Main");
	}
}
