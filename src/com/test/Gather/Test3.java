package com.test.Gather;

import java.util.*;


public class Test3 {

	public static void main(String[] args) {

		Hashtable <String, Student> map1 = new Hashtable<String, Student>();
		
		Student s1 = new Student("小王", 12);
		Student s2 = new Student("小李", 20);
		Student s3 = new Student("小智", 23);
		Student s4 = new Student("小蔡", 16);
		Student s5 = new Student("小龙", 20);
		
		map1.put("1", s1);
		map1.put("2", s2);
		map1.put("3", s3);
		map1.put("4", s4);
		map1.put("5", s5);
		
		System.out.println("key：");
		Set<String> keySet = map1.keySet();//获取Key值

		Iterator<String> ksi = keySet.iterator();//获取迭代器

		while(ksi.hasNext()) {
			String key = ksi.next();
			System.out.print(key);
			System.out.print(" 映射到 ");
			System.out.println(map1.get(key));
		}
		System.out.println("----------------");
		for (String key : keySet) {
			System.out.print(key);
			System.out.print("  映射到  ");
			System.out.println(map1.get(key));
		}
		System.out.println("value：");
		
		Collection<Student> values = map1.values();
		for (Student value : values) {
			System.out.println(value.toString());
		}
		
		System.out.println("entry：");
		
		Set<Map.Entry<String, Student>> enters = map1.entrySet();
		for (Map.Entry<String, Student> entry : enters) {
			System.out.print(entry.getKey());
			System.out.print("  --->  ");
			System.out.println(entry.getValue().toString());
		}
		System.out.println("----------------");
		Iterator<Map.Entry<String, Student>> eintr = enters.iterator();
		while(eintr.hasNext()) {
			Map.Entry<String, Student> entry = eintr.next();
			System.out.print(entry.getKey());
			System.out.print("  --->  ");
			System.out.println(entry.getValue().toString());
		}
		System.out.println("===============");

		System.out.println(map1.size());
		System.out.println("===============");
		
		Enumeration<Student> enumeration =  map1.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement().toString());
		}
		
	}

}
