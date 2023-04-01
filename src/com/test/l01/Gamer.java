package com.test.l01;

public class Gamer {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Role r1 = new Role("王宇翔",100);
        Role r2 = new Role("李泽轩",100);
        int num = 1;
        while(true) {
            System.out.println("=====第"+num+"回合=====");
            r1.attack(r2);
            if(r2.getBlood()==0) {
                System.out.println(r2.getName()+"被"+r1.getName()+"打死了");
                break;
            }

            r2.attack(r1);
            if(r1.getBlood()==0) {
                System.out.println(r1.getName()+"被"+r2.getName()+"打死了");
                break;
            }

            num++;

        }
    }


}
