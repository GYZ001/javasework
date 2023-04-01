package com.test.l02;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {

        //创建对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个小数");
        //接收输入
        double result = sc.nextDouble();
        //打印
        System.out.println(result);

    }
}
