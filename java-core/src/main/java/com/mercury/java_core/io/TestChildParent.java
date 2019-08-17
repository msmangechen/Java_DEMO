package com.mercury.java_core.io;

import java.io.ObjectStreamClass;

public class TestChildParent {

	public static void main(String[] args) {
		
		Parent parent = new Parent("Alex", 50);
		Child child = new Child("Jingmin", 25);
		
		Class parentClass = parent.getClass();
		Class childClass = child.getClass();
		
//		long parentUid = ObjectStreamClass.lookup(parentClass).getSerialVersionUID();
		long childUid = ObjectStreamClass.lookup(childClass).getSerialVersionUID();
		
		System.out.printf("serialVersionUID:\n");
//		System.out.printf("Child inherited from Parent: %d\n", child.serialVersionUID);
//        System.out.printf("Parent used by serialization: %d\n", parentUid);
        System.out.printf("Child used by serialization: %d\n", childUid);
		
	}

}
