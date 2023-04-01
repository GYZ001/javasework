package com.test.Multithreading.DigitalElimination;

public class Bread {
    private int num = -1;
    private boolean numexist = true;

    public synchronized void putNum(int num){
        if(!numexist){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.num = num;
        System.out.println("生成第"+ this.num +"块面包");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.numexist = false;
        notifyAll();
    }

    public synchronized void getNum() {
        if(numexist) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("吃掉第"+ this.num +"块面包");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.numexist = true;
        notifyAll();
    }
}
