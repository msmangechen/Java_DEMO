package com.mercury.java_core.collections;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeMapSet {

	public static void main(String[] args) {
		Student s1 = new Student("bob", 90, LocalDate.of(1990, 1, 1));
		Student s2 = new Student("alice", 100, LocalDate.of(1991, 2, 1));
		Student s3 = new Student("alex", 70, LocalDate.of(1992, 3, 1));
		// TreeMap 看comparable（优先级更高），当score一样时，TreeMap认为是同一个
		// 因此在Student的comparable增加年龄比较
		Student s4 = new Student("tom", 90, LocalDate.of(1989, 1, 1));
		Map<Student, Integer> studentsMap = new TreeMap<>(); // print follow key sequence 
		studentsMap.put(s1, 2);
		studentsMap.put(s2, 1);
		studentsMap.put(s3, 3);
		studentsMap.put(s4, 9);
		
		// TreeMap: sort by key
		studentsMap.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
		
		// TreeSet: sorted unique elements
		
		// how to sort by value?
		// TreeMap cannot do because TreeMap only can sort by key
		// HashMap cannot do because HashMap is unsorted
		// but LinkedHashMap can do!! 谁先insert谁在前面，可以用linked加comparator实现
		Map<String, Integer> lmap = new LinkedHashMap<>();
		lmap.put("a", 2);
		lmap.put("b", 3);
		lmap.put("c", 1);
		lmap.forEach((key, value) -> System.out.println(key + " " + value));
		
//		Set<Entry<String, Integer>> entries = lmap.entrySet();
//		Comparator<Entry<String, Integer>> comparator = (e1, e2) -> {
//			return e1.getValue() - e2.getValue();
//		};
//		Set<Entry<String, Integer>> sortedEntries = new TreeSet<>(comparator);
//		sortedEntries.addAll(entries);
//		Map<String, Integer> sortedMap = new LinkedHashMap<>();
//		for (Entry<String, Integer> entry : sortedEntries) {
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}
//		sortedMap.forEach((key, value) -> System.out.println(key + " " + value));
		
		// 重要！
		Map<Object, Object> sorted = lmap.entrySet().stream()
				.sorted((e1, e2) -> e1.getValue() - e2.getValue())
				.collect( // collectors.tomap will put into HashMap
					LinkedHashMap::new,
					(newMap, e) -> newMap.put(e.getKey(), e.getValue()), 
					Map::putAll // combiner
					// 如果用parallel stream，就会在不同thread创建不同的HashMap，用Map::putAll来combine
				);
		sorted.forEach((key, value) -> System.out.println(key + ": " + value));
	}
	
}
