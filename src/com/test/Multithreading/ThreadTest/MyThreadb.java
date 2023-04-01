package com.test.Multithreading.ThreadTest;

public class MyThreadb extends Thread {

    public MyThreadb() {
        this.setName("测试线程2");
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
                System.out.println("bbb");
                Thread.currentThread().sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
