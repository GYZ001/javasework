package com.test.Multithreading.DigitalElimination;


public class TestRun {
    public static void main(String[] args) {
        Bread bread = new Bread();
        new Producer(bread);
        new Consumer(bread);
    }
}
