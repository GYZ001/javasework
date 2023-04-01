package com.test.l04;

public class A01staticDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(21);
        s1.setGender("男");
        s1.study();
        s1.show();
    }
}
