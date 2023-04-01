package com.test.l01;

import java.util.Random;

public class Role {


    String name = null;
    int blood=100;

    public Role(String name, int blood) {
        super();
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBlood() {
        return blood;
    }
    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role r1) {

        Random r = new Random();
        int hurt = r.nextInt(5)+1;

        int reblood = r1.getBlood()-hurt;

        reblood = reblood<0?0:reblood;

        r1.setBlood(reblood);

        System.out.println(this.getName()+"举起拳头打向"+r1.getName()+""
                + "，造成了"+hurt+"伤害，"+r1.getName()+"还剩下"
                +r1.getBlood()+"血量");

    }


}

