package com.test.Multithreading.ThreadTest;

public class MyThreada extends Thread {

    public MyThreada() {
        this.setName("测试线程1");
        System.out.println("当前线程运行线程："+this.getName());
        System.out.println("当前线程运行优先级："+this.getPriority());
        System.out.println("当前线程运行状态："+this.isAlive());
        this.start();
        System.out.println("当前线程运行状态："+this.isAlive());
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5 ; i++) {
                System.out.println("aaa");
                Thread.currentThread().sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
