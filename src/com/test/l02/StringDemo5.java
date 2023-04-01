package com.test.l02;

import java.util.Scanner;

public class StringDemo5 {

    public static void main(String[] args) {

        //录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.next();

        //遍历

        for (int i = 0; i < str.length(); i++) {
            //i依次表示字符串的每一个索引
            char c = str.charAt(i);
            System.out.println(c);
        }

    }

}
