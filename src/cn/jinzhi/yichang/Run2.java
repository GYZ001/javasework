package cn.jinzhi.yichang;

public class Run2 {
    public static void main(String[] args) {
        try {
            System.out.println(10/0);
        }catch (ArithmeticException e){
            System.out.println();
        }
    }
}
