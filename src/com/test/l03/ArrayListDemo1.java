package com.test.l03;

import java.util.ArrayList;

public class ArrayListDemo1 {

    public static void main(String[] args) {
        //方法;add();remove();set();get();size();增删改查，长度
        ArrayList<String> al = new ArrayList<>();
        //泛型：限定集合中存取数据的类型
        al.add(new String("12345"));
        al.add(new String("gyz"));


        //Boolean a = al.remove("12345");   //remove("");
        //String a = al.remove(1);          //remove(index);
        //System.out.println(a);
        //al.set(1,"ddd");
        //String a = al.get(1);

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

    }
}
