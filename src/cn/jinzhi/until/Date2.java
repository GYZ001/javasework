package cn.jinzhi.until;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date2 {
    public static void main(String[] args) {
        Date d1 = new Date();
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH时mm分ss秒");

        c1.setTime(d1);//d转c
        Date d2 = c1 .getTime();//c转d
        String s = s1.format(d2);//d转S
        System.out.println(s);
        System.out.println(d1.toString());
        d1.setTime(100 * 60 * 60);
        System.out.println(d1.toString());

        Date d3 = new Date( );
        System.out.println(d3.before(d2));
        System.out.println(d2.before(d3));
        System.out.println(d3.getTime());

        Date d4 = new Date( );
        System.out.println(d4.equals(d3));
        System.out.println(d4 == d3);

        GregorianCalendar g1 = new GregorianCalendar(2000,1,
                1,00,00,00);
        System.out.println("这是"+g1.get(g1.YEAR)+"年"+g1.get(g1.MONTH)+"月"+ g1.get(g1.DATE)+
                "日"+g1.get(g1.HOUR)+"时"+g1.get(g1.MINUTE)+"分"+g1.get(g1.SECOND)+"秒");

    }
}
