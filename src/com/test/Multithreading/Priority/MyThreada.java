package com.test.Multithreading.Priority;

public class MyThreada extends Thread {

    public MyThreada() {
        this.setName("测试线程1");
        this.setPriority(10);
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("aaa");
        }
    }
}
