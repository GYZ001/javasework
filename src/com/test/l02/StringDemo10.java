package com.test.l02;

public class StringDemo10 {


    public static void main(String[] args) {

        String phonenumber = "18724532424";

        String start = phonenumber.substring(0, 3);

        String end = phonenumber.substring(7);

        String result = start + "****" + end;

        System.out.println(result);

    }


}
