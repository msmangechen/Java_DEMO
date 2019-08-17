package com.mercury.java_core.collections;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		Student s1 = new Student("bob", 90);
		Student s2 = new Student("alice", 100);
		Student s3 = new Student("alex", 70);
		Student s4 = new Student("bob", 90);
		Set<Student> studentsSet = new HashSet<>();
		studentsSet.add(s1);
		studentsSet.add(s2);
		studentsSet.add(s3);
		studentsSet.add(s4);
		System.out.println(studentsSet.size()); // 4, because java use equals to compare objects
	}

}
