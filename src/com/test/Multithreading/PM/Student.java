package com.test.Multithreading.PM;

public class Student implements Runnable {

    private String name = null;
    PM pm = null;

    public Student() {
    }

    public Student(String name, PM pm) {
        this.name = name;
        this.pm = pm;
    }

    @Override
    public void run() {
        synchronized (this.pm){
            this.pm.print(this.name);
        }
    }
}
