package com.mercury.java_core.collections;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class TestMap {

	public static void main(String[] args) {
		// of is a factory method, not a constructor method
		Student s1 = new Student("bob", 90, LocalDate.of(1990, 1, 1));
		Student s2 = new Student("alice", 100, LocalDate.of(1991, 2, 1));
		Student s3 = new Student("alex", 70, LocalDate.of(1992, 3, 1));
		Student s4 = new Student("bob", 90, LocalDate.of(1990, 1, 1));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		Map<Student, Integer> studentsMap = new HashMap<>();
		studentsMap.put(s1, 2);
		studentsMap.put(s2, 1);
		studentsMap.put(s3, 3);
		studentsMap.put(s4, 9);
		System.out.println(studentsMap.size());
		System.out.println();
		
		// how to print HashMap?
		// 1. keySet()
		Set<Student> keys = studentsMap.keySet();
		for (Student key : keys) {
			System.out.println(key.getName() + ": " + studentsMap.get(key));
		}
		// 2. entrySet(): 重要，不写Node，因为最好用它的implementation，就是Entry
		Set<Map.Entry<Student, Integer>> entries = studentsMap.entrySet();
		for (Map.Entry<Student, Integer> entry : entries) {
			System.out.println(entry.getKey().getName() + ": " + entry.getValue());
		}
		
		// HashTable, ConcurrentHashMap
		
		// LinkedHashMap: keep insertion order (只有LinkedHashMap是有序的
		Map<Student, Integer> studentsLinkedMap = new LinkedHashMap<>();
		studentsLinkedMap.put(s1, 2);
		studentsLinkedMap.put(s2, 1);
		studentsLinkedMap.put(s3, 3);
		studentsLinkedMap.put(s4, 9);
		// BiConsumer: 代表take two parameters，Consumer take one parameter用在List中
		studentsLinkedMap.forEach(new BiConsumer<Student, Integer>() {

			@Override
			public void accept(Student key, Integer value) { // 相当于JS的callback function
				System.out.println(key.getName() + ": " + value);
			}
			
		});
		// lambda function，等同于上面的function，只能用在interface上
		// Java并不支持callback function
		studentsLinkedMap.forEach((key, value) -> {
			// 这个function就是accept方法，用lambda必须是functional interface
			// functional interface：这个接口（BiConsumer）必须只有一个abstract method
			// 可以有多个static/default方法
			System.out.println(key.getName() + ": " + value);
		});
		
	}
	
}
