package com.test.Multithreading.DigitalElimination;

public class Producer implements Runnable{
    private int i = 0;
    private Bread bread = null;

    public Producer(Bread bread) {
        this.bread = bread;
        Thread thread = new Thread(this,"Producer");
        thread.start();
    }

    @Override
    public void run() {
        for(int j = 0; j < 10; j++) {
            this.bread.putNum(++i);
        }
    }

}
