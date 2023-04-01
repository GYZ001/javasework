package cn.jinzhi.throwable;

public class B {
    public void bb() throws NullPointerException{
        System.out.println("bb开始");
        try {

            String s1 =null;
            System.out.println(s1.length());
        }catch (NullPointerException e){
            System.out.println("里层空指针");
            throw e;
        }

        System.out.println("bb结束");
    }
}
