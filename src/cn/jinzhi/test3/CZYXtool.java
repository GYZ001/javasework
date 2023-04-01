package cn.jinzhi.test3;

import java.util.Random;

public class CZYXtool {
    public static void jh(char[] c){
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            int n1 = ran.nextInt(4);
            int n2 = ran.nextInt(4);
            if (n1 == n2){
                continue;
            }
            char tempt;
            tempt = c[n1];
            c[n1] = c[n2];
            c[n2] =tempt;
        }
    }
}
