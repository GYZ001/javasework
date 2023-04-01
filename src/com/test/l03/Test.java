package com.test.l03;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        ArrayList<GirlFriend> girlFriendArrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String n = "#";
        while (n.equals("#")){
            GirlFriend gf = new GirlFriend();

            System.out.println("请输入对象的姓名：");
            gf.setName(sc.next());

            System.out.println("请输入对象年龄：");
            gf.setAge(sc.nextInt());

            girlFriendArrayList.add(gf);
            System.out.println("输入#继续添加，任意键退出");
            n = sc.next();

        }

        for (int i = 0; i < girlFriendArrayList.size(); i++) {
            GirlFriend girlFriend = girlFriendArrayList.get(i);
            System.out.println("女友"+(i+1)+"姓名："+girlFriend.getName()+
                    ",年龄："+girlFriend.getAge());

        }
    }


}
