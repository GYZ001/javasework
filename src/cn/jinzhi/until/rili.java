package cn.jinzhi.until;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class rili {
    public static void main(String[] args) {

        GregorianCalendar gc1 = new GregorianCalendar();
        int theyear = gc1.get(Calendar.YEAR);
        int themonth = gc1.get(Calendar.MONTH);
        int today = gc1.get(Calendar.DATE);

        gc1.set(theyear,0,1);

        while(gc1.get(Calendar.YEAR) < theyear+10){
            int month = gc1.get(Calendar.MONTH);
            int year = gc1.get(Calendar.YEAR);
            System.out.println();
            System.out.println("=========="+year+"年"+(month+1)+"月=========");

            System.out.println("sun mon tue wed thu fri sat");

            for(int i = Calendar.SUNDAY; i < gc1.get(Calendar.DAY_OF_WEEK); i++) {
                System.out.print("    ");
            }

            while(gc1.get(Calendar.MONTH) == month) {
                int day = gc1.get(Calendar.DATE);
                if(day < 10) {
                    System.out.print(" ");
                }
                System.out.print(" " + day);
                if((day == today)&&(month ==themonth)&&(theyear==gc1.get(Calendar.YEAR))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                if(gc1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                    System.out.println();
                }
                gc1.add(Calendar.DATE, 1);

            }

        }
    }
}
