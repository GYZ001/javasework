package com.test.Gather;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		Map<String, Student> map1 = new HashMap<String, Student>();

		Student s1 = new Student("小王", 12);
		Student s2 = new Student("小李", 20);
		Student s3 = new Student("小智", 23);
		Student s4 = new Student("小蔡", 16);
		Student s5 = new Student("小龙", 20);
		
		map1.put("1", s1);
		map1.put("2", s2);
		map1.put("3", s5);
		map1.put("4", s3);
		map1.put("4", s3);
		System.out.println(map1.size());
		map1.remove("bj");
		System.out.println(map1.size());
		System.out.println("==============");
		map1.put("2", s2);
		System.out.println(map1.size());
		System.out.println("==============");
		Student wk1 = map1.get("1");
		System.out.println(wk1.toString());
		System.out.println("==============");
		System.out.println(map1.containsKey("1"));
		System.out.println(map1.containsValue(new Student("cxk", 20)));
		
		
		
		
		
	}

}
