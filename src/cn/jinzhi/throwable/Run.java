package cn.jinzhi.throwable;

public class Run {
    public static void main(String[] args) {
        System.out.println("run开始");

        B b = new B();

        try{
            b.bb();
        }catch (NullPointerException e){

        }

        System.out.println("run结束");
    }
}
