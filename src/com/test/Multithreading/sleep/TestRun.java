package com.test.Multithreading.sleep;

public class TestRun {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5 ; i++) {
                System.out.println("aaa");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
