package com.test.l02;

import java.util.Scanner;

public class StringDemo6 {
    public static void main(String[] args) {

        //录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.next();
        //统计
        int bigcount = 0;
        int smallcount = 0;
        int numcount = 0;
        int asciicount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                //char在计算的时候自动变为int类型的ascii表
                smallcount++;
            } else if (c >= 'A' && c <= 'Z') {
                bigcount++;
            } else if (c > '0' && c <= '9'){
                numcount++;
            }else{
                asciicount++;
            }
        }
        System.out.println("小写字母有"+smallcount+"个");
        System.out.println("大写字母有"+bigcount+"个");
        System.out.println("数字有"+numcount+"个");
        System.out.println("其他字符有"+asciicount+"个");
    }
}
