package cn.jinzhi.test3;

public class Run {
    public static void main(String[] args) {

        StringBuffer sb1 = new StringBuffer();

        sb1.append("sb1");
        System.out.println(sb1);

        sb1.delete(0,1);
        System.out.println(sb1);

        sb1.insert(1,"1234");
        System.out.println(sb1);

        sb1.reverse();
        System.out.println(sb1);
    }
}
