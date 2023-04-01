package com.test.l02;

import java.util.Scanner;

public class StringDemo9 {

    public static void main(String[] args) {

        //键盘录入金额
        Scanner sc = new Scanner(System.in);
        int money;
        while (true) {
            System.out.println("请输入一个金额：");
            money = sc.nextInt();
            if (money >= 0 && money <= 99999999) {
                break;
            } else {
                System.out.println("金额无效");
            }
        }

        String moneyStr = "";
        //得到每一位数字
        while (true) {
            //从右往左获取数据
            int ge = money % 10;
            String number = getNumber(ge);
            moneyStr = number+moneyStr;

            //去掉刚刚获取的数据
            money = money / 10;
            if (money == 0) break;
        }


        //在前面补0
        int count = 8 - moneyStr.length();
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }

        //插入单位
        String[] arr = {"仟","佰", "拾", "万", "仟", "佰", "拾", "元"};
        //遍历moneyStr，依次得到
        //把arr插入之间
        String result = "";
        for (int i = 0; i < moneyStr.length(); i++) {
            char c = moneyStr.charAt(i);
            result = result + c + arr[i];
        }

        System.out.println(result);
    }


    public static String getNumber(int num) {
        //定义数组，数字跟大写中文产生对应关系
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        //返回结果
        return arr[num];
    }

}
