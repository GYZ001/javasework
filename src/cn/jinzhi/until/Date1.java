package cn.jinzhi.until;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date1 {
    public static void main(String[] args) {
//        Date d0 = new Date();
//        d0.setDate(18);
//        System.out.println(d0.toString());
//
//        Date d2 = new Date(49,10,1);
//        System.out.println(d2);

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR,2000);
        c1.set(Calendar.MONTH,0);
        c1.set(Calendar.DATE,1);
        int y = c1.get(Calendar.YEAR);
        int m = c1.get(Calendar.MONTH);
        int d = c1.get(Calendar.DATE);
        System.out.println("出生日期：");
        System.out.println(y+"年"+(m+1)+"月"+d+"日");
        c1.add(Calendar.DATE,10000);
        int y1 = c1.get(Calendar.YEAR);
        int m1 = c1.get(Calendar.MONTH);
        int d1 = c1.get(Calendar.DATE);
        System.out.println("出生一万天后：");
        System.out.println(y1+"年"+(m1+1)+"月"+d1+"日");


    }
}
