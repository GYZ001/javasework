package com.test.l02;

public class StringDemo {

    public static void main(String[] args) {
        //字符串内容无法修改

        //使用直接赋值的方式
        String s1 = "abc";
        System.out.println(s1);

        //使用new的方式
        String s2 = new String();
        System.out.println("@" + s2 + "！");

        //有参构造

        //字符数组
        //当需要修改字符串内容的时候  abc-->qbc
        //abc--->{a,b,c}--->{qbc}--->"qbc"
        char[] chs = {'a', 'b', 'c', 'd'};
        String s3 = new String(chs);
        System.out.println(s3);

        //传递字节数组
        //网络应用的时候传输的都是字节信息
        byte[] bt = {97, 98, 99, 100, 101};// ascall码的值
        String s5 = new String(bt);
        System.out.println(s5);

    }
}
