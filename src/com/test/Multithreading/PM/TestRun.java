package com.test.Multithreading.PM;

public class TestRun {
    public static void main(String[] args) {

        Thread thread1 = null;
        Thread thread2 = null;
        Thread thread3 = null;

        PM pm = new PM();

        Student student1 = new Student("老板",pm);
        Student student2 = new Student("社畜",pm);
        Student student3 = new Student("股东",pm);

        thread1 = new Thread(student1);
        thread2 = new Thread(student2);
        thread3 = new Thread(student3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
