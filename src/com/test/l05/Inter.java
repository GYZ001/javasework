package com.test.l05;

public interface Inter {

    int a = 10 ;

    //jdk7
    void method();

    //jdk8可以定义有方法体的方法
    default void jdk8(){

    }

    static void jdk88(){

    }

    //jdk9给默认方法去服务

//    private void log(){
//      给普通方法服务
//    }
//    private static void log1(){
//      给静态方法服务
//    }


    //jdk9 适配器
    //public abstract class InterAdapt implements Inter
    //Interimpl extends InterAdapt


}
