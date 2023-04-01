package com.test.Multithreading.Priority;

public class MyThreadb extends Thread {

    public MyThreadb() {
        this.setName("测试线程2");
        this.setPriority(1);
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("bbb");
        }
    }
}
