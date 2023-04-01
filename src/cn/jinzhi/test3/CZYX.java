package cn.jinzhi.test3;

import java.util.Random;
import java.util.Scanner;

public class CZYX {
    public static void main(String[] args) {
        String[] yw = "人生若只如初见，何事秋风悲画扇，等闲变却故人心，却道故人心易变".split("，");
        char[] answer = new char[4];
        String[] das = new String[4];
        Random r1 = new Random();
        for (int i = 0; i <yw.length ; i++) {
            int n = r1.nextInt(7);
            answer[i] = yw[i].charAt(n);
        }
        for (int i = 0; i <yw.length ; i++) {
            yw[i] = yw[i].replace(answer[i],'?');
        }
        StringBuffer zqda = new StringBuffer();
        for (int i = 0; i < 4 ; i++) {
            zqda.append(answer[i]);
        }

        int zqwz = r1.nextInt(4);
        das[zqwz] = zqda.toString();
        for (int i = 0; i < yw.length; i++) {
            if (i == zqwz){
                continue;
            }
            CZYXtool.jh(answer);
            if (!zqda.equals(answer)){
                String CWDA = new StringBuffer().append(answer[0]).
                        append(answer[1]).append(answer[2]).append(answer[3]).toString();
                das[i] = CWDA;
            }else{
                i--;
            }
        }

        for (int i = 0; i < yw.length; i++) {
            System.out.println(yw[i]);
        }
        for (int i = 0; i < das.length; i++) {
            System.out.println((1+i)+"、"+das[i]);
        }


        System.out.println("请输入你的选择：");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(zqwz+1 == n){
            System.out.println("恭喜你答对了!");
        }else{
            System.out.println("回去好好学习！");
        }

    }
}
