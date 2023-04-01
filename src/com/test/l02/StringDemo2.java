package com.test.l02;

public class StringDemo2 {

    public static void main(String[] args) {

        //创建两个字符串对象
        String s1 = new String("abc");
        String s2 = "abc";
        //==比较
        System.out.println(s1==s2);
        //equals比较内容
        System.out.println(s1.equals(s2));
    }
}
