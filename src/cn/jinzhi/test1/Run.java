package cn.jinzhi.test1;

import com.test.l05.Inter;

public class Run {
    public static void main(String[] args) {

        Integer i1 = new Integer(999);
        System.out.println(i1);

        Integer i2 = 11;
        System.out.println(i2);

        int a = i2.intValue();
        System.out.println(a);

        Integer i3 = Integer.valueOf(a);
        System.out.println(i3);

        int b = Integer.parseInt("666");
        System.out.println(b);

        System.out.println(i1.toString());
    }
}
