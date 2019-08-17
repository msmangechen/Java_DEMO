package com.mercury.java_core.collections;

import java.time.LocalDate; // Java 8 API, 之前用Date

public class Student implements Comparable<Student> {

	private String name;
	private int score;
	private LocalDate birthday; // LocalDateTime

	public Student() {
		super();
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public Student(String name, int score, LocalDate birthday) {
		super();
		this.name = name;
		this.score = score;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public int compareTo(Student o) {
		int result = o.getScore() - score;
		if (result == 0) {
			return birthday.compareTo(o.getBirthday());
		} else {
			return result;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", birthday=" + birthday + "]";
	}
	
	@Override
	public int hashCode() {
//		return (int) (Math.random() * 1000);
		return name.hashCode() + birthday.hashCode();
	}
	
	// HashCode设计原则：
	// equals return true, hashCode() must be same.
	// hashCode() are same, equals may return true or false (eg. 120+80 = 150+50)
	
	// 同样name和birthday的学生是同一个学生
	// 根据Override，必须是Object，Comparator和Comparable是因为泛型指定Student
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		// name: this.name, so it's current student name
		return name.equals(other.getName()) && birthday.equals(other.getBirthday());
	}

}
