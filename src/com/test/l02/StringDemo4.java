package com.test.l02;

import java.util.Scanner;

public class StringDemo4 {

    public static void main(String[] args) {
        //实现用户登录

        //定义变量
        String rightname = "zhangsan";
        String rightpassword = "123456";


        //模拟用户登录
        for (int i = 0; i < 3; i++) {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();
            //比较
            if (rightname.equals(username) && rightpassword.equals(password)) {
                System.out.println("登录成功");
                break;
            } else {
                if((2-i)==0){
                    System.out.println("您的账户已经被锁定");
                    break;
                }
                System.out.println("输入非法,还剩" + (2 - i) + "次机会");
            }

        }

    }
}
