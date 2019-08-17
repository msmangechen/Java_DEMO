package com.mercury.java_core.inner_class;

public class Outer {

	static int a = 1;
	static final int b = 2;
	int c = 3;
	final int d = 4;

	// static inner class: 只拥有一份，被共享
	static class StaticInner {
		static int x = 1;
		int y = 1;

		public void test() { // 只能用static
			System.out.println(a);
			System.out.println(b);
			// System.out.println(c);
			// System.out.println(d);
		}
	}

	// non-inner class: must have instance to use，每个instance都maintain一份
	class NonStaticInner {
		// only allows static final variable, cannot be change
		static final int x = 1; // static: only has one, 如果其中一个x更改了，那所有的都会被更改
		int y = 1;

		public void test() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
		}
	}

	public static void main(String[] args) {
		Outer outer = new Outer();
		StaticInner si = new StaticInner();
		NonStaticInner nsi = outer.new NonStaticInner();
		int t = 0;
		t = -1;
		final int s = 0;

		// local Inner class: must be in method, can only use in the current method
		// declared
		class LocalInner {
			static final int x = 1;
			int y = 1;

			// Outer is effectively final: never change during execution
			public void test() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(outer);
				// System.out.println(t); // t modified, so it's not effectively final
				System.out.println(s);
			}
		}
		LocalInner li = new LocalInner();
	}

}
