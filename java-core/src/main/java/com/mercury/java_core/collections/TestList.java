package com.mercury.java_core.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestList {

	public static void main(String[] args) {
		// Comparator
		int[] arr = new int[10];

		// < 1.7, ArrayList<Integer>, >= 1.7 ArrayList<>
		List<Integer> l = new ArrayList<>(); // {}, ()内可以自定义length
		l.add(1); // {} -> new Integer[10], elementData.length=10, 填满10个后扩容到原本的1.5倍
		l.add(3);
		l.add(2);
		System.out.println(l);

		// Collection: Interface; Collections: class
		Collections.sort(l, new IntegerDescComparator());
		
		// Anonymous class
		Collections.sort(l, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
		
		// Comparator lambda 简写: 因为是functional interface
		// 只有一个return的时候，可以省略
		Collections.sort(l, (o1, o2) -> (o2 - o1));
		
		System.out.println(l);

		List<String> l1 = new LinkedList<>();
		l1.add("B");
		l1.add("A");
		l1.add("C");
		System.out.println(l1);

		// Comparable
		Student s1 = new Student("bob", 90);
		Student s2 = new Student("alice", 100);
		Student s3 = new Student("alex", 70);
		// s1.compareTo(s2)
		List<Student> studentsList = new ArrayList<>();
		studentsList.add(s1);
		studentsList.add(s2);
		studentsList.add(s3);
		
//		Collections.sort(studentsList, new Comparator<Student>() {
//		
//		@Override
//		public int compare(Student o1, Student o2) {
//			return o2.getScore() - o1.getScore();
//		}
//		
//		});
		Collections.sort(studentsList);
		System.out.println(studentsList);

		// Stream(Observable) API: Java 8
		// reactive programming + functional programming
		// 响应式数据，流动的data
		Stream<Student> stream = studentsList.stream();
		// override Predicate test() method
		
		// intermediate operation: 只有一个stream，成为过滤后还是stream，不终止operation
		// filter(), map(), distinct, sorted, skip, limit
		
		// terminal operation：stream转为list，终止operation，原来的stream不存在了
		// count, collect(), findAny, findFirst
		// allMatch, anyMatch, noneMatch (return boolean)
		// min, max
		List<Student> list = stream.filter(s -> s.getScore() >= 90)
				// function: override apply(), 对每个学生的分数+5
				.map(s -> {
					s.setScore(s.getScore() + 5);
					return s;
				})
				.filter(s -> s.getScore() > 100)
//				.map(s -> s.getName())
				.map(Student::getName) // method reference, 等同于上面，对lambda简写
//				.map(name -> new Student(name))
				.map(Student::new) // 等同于上面
				.collect(Collectors.toList());
		System.out.println(list);
		
		// int: use the stream(int[] array) method
		// Integer: use the stream(T[] array) method
		Integer[] data = {5, 2, 4, 11, 6, 5, 2}; // change int to Integer, so the generic type will be match
		Stream<Integer> dataStream = Arrays.stream(data);
		Optional<Integer> anyDataOptional = dataStream.filter(d -> d <= 9)
					.distinct() // remove duplicate element
//					.peek(d -> System.out.println(d)) // Consumer, 会执行不会改变流
					.peek(System.out::println) // class :: method()
					.sorted((o1, o2) -> (o2 - o1)) // sort array
					.skip(1) // 1是count
					.limit(2) // get the first 2 elements, return {5, 4}, 以上全是intermediate operation
//					.count() // return long, not stream, terminal operation
//					.collect(Collectors.toList())
					.findAny(); // return Optional object, Java8
//					.anyMatch(d -> d % 2 == 0) // allMatch, noneMatch
//					.min((o1, o2) -> o1 - o2) // 从前往后找，max()
		
		// Optional: 避免NullPointerException
		int anyData = 0;
//		if (anyDataOptional.isPresent()) { // 如果Optional有值
//			anyData = anyDataOptional.get();
//		} else {
//			++anyData;
//		}
		
		final int DEFAULT_DATA = 999;
		anyData = anyDataOptional.orElse(1); // 等同于上面，在else中，anyData=1
		anyData = anyDataOptional.orElseGet(() -> {
//			++anyData; // error
			return DEFAULT_DATA; // lambda can only use final or effectively final instance
		});
		
		int[] array = {5, 2, 4};
		IntStream intDataStream = Arrays.stream(array);
		System.out.println(intDataStream.average()); // 直接使用，不需要有排序
		
	}
}
