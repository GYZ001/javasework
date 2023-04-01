package cn.jinzhi.throwable;

public class A {
    public void aa() throws ClassNotFoundException {
        System.out.println("aa begin");

        try {
            Class.forName("cn.jinzhi.throwable.B");
            System.out.println("bbbb");
        }catch (ClassNotFoundException e){
            System.out.println("里层发现异常");
            throw e;
        }finally {
            System.out.println("里层最后一句话");
        }

        System.out.println("aa end");
    }

}
