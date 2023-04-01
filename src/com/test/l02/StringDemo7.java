package com.test.l02;

public class StringDemo7 {


    public static void main(String[] args) {

        int[] arr = {1,2,3};
        String str = arrToString(arr);
        System.out.println(str);
    }
    //我要干嘛
    //需要什么才能完成
    //是否需要返回

    public static String arrToString(int[] arr){
        if (arr == null){
            return "";
        }
        if (arr.length == 0){
            return "[]";
        }
        //表示数组不是null，不是空，有内容

        String result ="[";

        for (int i = 0; i < arr.length; i++) {
            //i索引
            if(i == arr.length-1){
                result = result +arr[i];
            }else{

                result = result + arr[i]+", ";
            }

        }

        result = result+"]";
        return result;
    }

}
