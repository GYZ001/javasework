package com.test.l03;

import java.util.ArrayList;

public class ArrayListDemo2 {
    public static void main(String[] args) {

        ArrayList<String> ar = new ArrayList<>();
        ar.add("复习了吗");
        ar.add("学新的了吗");
        ar.add("发现不足了吗");
        ar.add("改进自己了吗");
        System.out.print("[");
        for (int i = 0; i < ar.size(); i++) {
            if (i == ar.size()-1){
                System.out.print(ar.get(i));
            }else {
                System.out.print(ar.get(i)+",");
            }
        }
        System.out.print("]");

        System.out.println(ar);

    }
}
