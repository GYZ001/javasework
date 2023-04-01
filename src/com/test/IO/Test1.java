package com.test.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;// 声明字节流输入输出实例名
        FileOutputStream out = null;

        try {
            in = new FileInputStream("./a.txt");//字节流源头设置，实例生成
            out = new FileOutputStream("./b.txt");

            int info = -2;//中间传输为int类型的后八位
            while (true) {
                info = in.read();//获取读取数据
                if (info == -1) {
                    break;
                }
                System.out.print((char) info);
                out.write(info);
                out.flush();//写入读取数据

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
