package com.test.Multithreading.PM;

public class PM {
    public void print(String info) {
        try {
            System.out.print("[" + info);
            Thread.currentThread().sleep(1000);
            System.out.println("]");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
