package com.test.l01;

public class test {
    public static void main(String[] args) {
        System.out.println(num(4));
    }

    public static int num(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return num(n-1) + num(n-2);
    }
}
