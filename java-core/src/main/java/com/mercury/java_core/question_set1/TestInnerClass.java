package com.mercury.java_core.question_set1;

public class TestInnerClass {
	public static void main(String[] args) {
//		Egg egg = new BigEgg();
		Egg2 egg2 = new BigEgg2();
		egg2.g();
	}
}

//class Egg {
//	protected class Yolk {
//		public Yolk() {
//			System.out.println("Egg.Yolk");
//		}
//	}
//	private Yolk y;
//	public Egg() {
//		System.out.println("New Egg");
//		y = new Yolk();
//	}
//}
//class BigEgg extends Egg {
//	public class Yolk extends Egg.Yolk {
//		public Yolk() {
//			System.out.println("BigEgg.Yolk");
//		}
//	}
//}

class Egg2 {
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg2.Yolk");
		}
		public void f() {
			System.out.println("Egg2.Yolk.f");
		}
	}
	// 先初始化instance field
	private Yolk y = new Yolk();
	public Egg2() {
		System.out.println("New Egg2");
	}
	public void insertYolk(Yolk yy) {
		y = yy;
	}
	public void g() {
		y.f();
	}
}
class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			System.out.println("BigEgg2.Yolk");
		}
		public void f() {
			System.out.println("BigEgg2.Yolk.f");
		}
	}
	public BigEgg2() {
		// 先创建父类的constructor
		insertYolk(new Yolk());
	}
}
