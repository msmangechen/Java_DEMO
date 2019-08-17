package com.mercury.java_core.shallow_deep;

public class Father implements Cloneable{
	
	public String name;
	public int age;
	public Child child;
	
	// Shallow copy
//	@Override
//	public Father clone() {
//		try {
//			return (Father) super.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	// Deep copy
	@Override
	public Father clone() {
		try {
			Father cloneFather = (Father) super.clone();
			cloneFather.child = (Child) this.child.clone();
			return cloneFather;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Father fatherA = new Father();
		fatherA.name = "Bob";
		fatherA.age = 30;
		fatherA.child = new Child();
		Father fatherB = fatherA.clone();
		
		System.out.println(fatherA == fatherB);
		System.out.println(fatherA.hashCode());
		System.out.println(fatherB.hashCode());
		System.out.println(fatherA.child == fatherB.child);
		System.out.println(fatherA.name);
		System.out.println(fatherB.name);
	}
}
