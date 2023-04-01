package com.test.IO;

import java.io.*;

public class Test3 {
    public static void main(String[] args) {
        Reader reader = null;//字符流实例名
        Writer writer = null;

        try {
            reader = new FileReader("./a.txt");//字符流实例空间生成，源头目标文件设置
            writer = new FileWriter("./c.txt");

            int info = -2;
            while ((info = reader.read()) != -1) {
                writer.write(info);
                writer.flush();//字符流写入
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null) {
                    writer.close();
                    writer = null;
                }
                if(reader != null) {
                    reader.close();
                    reader = null;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
