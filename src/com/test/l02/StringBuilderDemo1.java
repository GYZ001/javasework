package com.test.l02;

public class StringBuilderDemo1 {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.capacity());
        System.out.println(stringBuilder.length());
        //默认创建16,16*2+2,n

    }
}
