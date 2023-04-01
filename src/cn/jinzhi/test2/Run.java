package cn.jinzhi.test2;

public class Run {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aa";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = new String("bb");
        String s4 = new String("bb");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        System.out.println(s4.length());
        System.out.println("aaa".length());

        String s5 = "bb123456";
        System.out.println(s5.compareTo(s4));
        System.out.println("a".compareTo("z"));

        System.out.println("abc".startsWith("abd"));
        System.out.println("abc".endsWith("c"));

        System.out.println("ABIDE".indexOf("DE"));
        System.out.println("ABC".charAt(2));

        System.out.println("ABIDING".substring(2));
        System.out.println("ACIDLY".substring(2,5));
        //优先使用java端的方法来处理数据
        System.out.println("abeeefg".replace('e','k'));
        System.out.println("aa".replaceAll("a","b"));
    }
}
