package cn.jinzhi.yichang;

public class Run1 {
    public static void main(String[] args) {

        String s1 = "ok";
        int a = 1;
        try {
            System.out.println(s1.length());
            System.out.println(10/a);
            Class.forName("cn.jinzhi.test1.Run");
            System.out.println("666");
        }catch (NullPointerException e){
            s1 = "";
            System.out.println(s1.length());
        }catch (ArithmeticException e){
            a = 1;
            System.out.println(10/a);
        }catch (ClassNotFoundException e){
            System.out.println("No!");
        }
    }
}
