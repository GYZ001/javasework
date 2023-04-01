package com.test.IO;

import java.io.*;

public class Test4 {

    public static void main(String[] args) {
        BufferedReader reader = null;//字符流实例名
        BufferedWriter writer = null;

        String info = null;
        try {

            reader = new BufferedReader(new FileReader("./a.txt"));//字符流借用字节流完成物理层面的操作
            writer = new BufferedWriter(new FileWriter("./b.txt"));
            while ((info = reader.readLine()) != null) {
                writer.write(info + "\n");
                writer.flush();//字符流输入，也借用了字节流完成物理层面的传输
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null){
                    reader.close();
                    reader = null;
                }
                if (writer != null){
                    writer.close();
                    writer = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
