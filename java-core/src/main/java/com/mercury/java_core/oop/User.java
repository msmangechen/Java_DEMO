package com.mercury.java_core.oop;

// have to implements Cloneable if we want to use Clone
public class User implements Cloneable {

	String name;
	int age;
	
	public User() {
		
	}

	public User(String name, int age) {
		if (name == null) {
			throw new IllegalArgumentException("Name can't be null!");
		}
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof User)) {
			return false;
		}
		// down casting (from Parent to Child), in order to compare name and age
		User u = (User) obj;
		return u.name.equals(this.name) && u.age == this.age;
	}
	
	private void hi() {
		System.out.println("private hi in User");
	}
	
	// Object可以用，不过User 不需要在用的时候 downcasting (in TestCloneable)
	public User clone() throws CloneNotSupportedException {
		return (User) super.clone();
	}
	// throws: 往上扔锅，让上面的handle clone exception
	// try catch: 使用try catch的地方就handle exception

	public static void main(String[] args) {
		User u1 = new User("Bob", 10);
		User u2 = new User("Bob", 10);
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));
		System.out.println(u1.equals("abc"));
		u1.hi();
	}

}
