package com.test.Multithreading.ThreadTest;

public class TestRun {
    public static void main(String[] args) {

        System.out.println("当前运行中的线程数："+Thread.activeCount());

        new MyThreada();
        new MyThreadb();
        new TimeThread();

        System.out.println("当前运行中的线程数："+Thread.activeCount());
    }
}
