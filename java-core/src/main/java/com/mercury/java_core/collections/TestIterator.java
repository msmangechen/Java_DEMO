package com.mercury.java_core.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestIterator {

	public static void main(String[] args) {
		Student s1 = new Student("bob", 90);
		Student s2 = new Student("alice", 100);
		Student s3 = new Student("alex", 70);
		List<Student> studentsList = new ArrayList<>();
		studentsList.add(s1);
		studentsList.add(s2);
		studentsList.add(s3);
		Iterator<Student> it = studentsList.iterator();
		// PPT2 page 13
		// after iterator creates, then modify the structure, will throw ConcurrentModificationException
//		studentsList.add(new Student("dummy", 99)); // fail-fast Iterator
		while (it.hasNext()) {
			Student student = it.next();
			System.out.println(student);
//			studentsList.add(new Student("dummy", 99)); // infinity loop: ConcurrentModificationException
		}
		
		// fail-safe: ConcurrentHashMap, CopyOnWriteArrayList
		// list set queue 是collection，map不是collection，没有iterator
		Map<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Set<Integer> keys = map.keySet();
		Iterator<Integer> mit = keys.iterator(); // ConcurrentHashMap独有：每个thread做一份copy of iterator
		while (mit.hasNext()) {
			System.out.println(mit.next());
		}
	}

}
