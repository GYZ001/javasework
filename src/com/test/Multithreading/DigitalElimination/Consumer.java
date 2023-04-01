package com.test.Multithreading.DigitalElimination;

public class Consumer implements Runnable {
    private Bread bread = null;

    public Consumer(Bread bread) {
        this.bread = bread;
        Thread thread = new Thread(this, "Consumer");
        thread.start();
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            this.bread.getNum();
        }
    }

}
