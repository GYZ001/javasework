package com.test.l02;

import java.util.Scanner;

public class StringDemo11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入身份证号：");
        String id = sc.next();

        String year = id.substring(6, 10);
        String mouth = id.substring(10, 12);
        String day = id.substring(12, 14);
        System.out.println("出生日期：" + year + "年" + mouth + "月" + day + "日");

        int sex = (id.charAt(16)-48) % 2;

        if (sex == 1){
            System.out.println("性别为：男");
        }else {
            System.out.println("性别为：女");
        }


    }
}
