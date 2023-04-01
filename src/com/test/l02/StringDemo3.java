package com.test.l02;

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args) {

        // 键盘录入一个abc
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str1 = sc.next();
        //代码中定义abc
        String str2 = "abc";
        //用==比较
        System.out.println(str1==str2);//结果是false, "=="在对象之间是对比地址值，str2是值，str1是对象。

        //结论，比较字符串之间的信息必须使用String内部的方法。
    }
}
