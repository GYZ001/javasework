package com.test.Multithreading;

public class ThreadLocalExample {

    // 创建一个ThreadLocal对象
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建两个线程，分别设置线程本地变量的值
        Thread thread1 = new Thread(() -> {
            threadLocal.set("value1");
            System.out.println("Thread 1 get value: " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("value2");
            System.out.println("Thread 2 get value: " + threadLocal.get());
        });

        // 启动两个线程
        thread1.start();
        thread2.start();
    }
}
