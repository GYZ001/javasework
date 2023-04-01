package cn.jinzhi.yichang;

public class Run {

    public static void main(String[] args) {

        String s1 = null;
        int a = 0;
        try {
            System.out.println(s1.length());
        }catch (NullPointerException e){
            s1 = "";
            System.out.println(s1.length());
        }

        try {
            System.out.println(10/a);
        } catch (ArithmeticException e) {
            a = 1;
            System.out.println(10/a);
        }

        try {
            Class.forName("com.jinzhi.test");
        }catch (ClassNotFoundException e){
            System.out.println("没有这个类");
        }

        System.out.println("over");
    }

}
