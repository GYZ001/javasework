package com.test.Gather;

import java.util.*;


public class Test1 {

	public static void main(String[] args) {
		Set<Student> set1 = new HashSet<Student>();
		Student s1 = new Student("小王", 12);
		Student s2 = new Student("小李", 20);
		Student s3 = new Student("小智", 23);
		Student s4 = new Student("小蔡", 16);
		Student s5 = new Student("小龙", 20);
		
		set1.add(s1);
		set1.add(s2);
		for (Student student : set1) {
			System.out.println(student.toString());
		}
		System.out.println("======================");
		set1.add(s5);
		for (Student student : set1) {
			System.out.println(student.toString());
		}
		System.out.println("======================");
		set1.add(null);
		System.out.println(set1.size());
	}

}
