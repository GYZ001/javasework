package com.test.IO;

import java.io.*;

public class Test5 {
    public static void main(String[] args) {
        DataInputStream dataInputStream = null;
        DataOutputStream outputStream = null;

        String[] name = {"张三", "李四", "王五"};
        int[] age = {21, 22, 43};

        try {
            outputStream = new DataOutputStream(new FileOutputStream("./b.txt"));

            for (int i = 0; i < 3; i++) {
                outputStream.writeUTF(name[i]);
                outputStream.writeInt(age[i]);
            }

            dataInputStream = new DataInputStream(new FileInputStream("./b.txt"));

            for (int i = 0; i < 3; i++) {
                System.out.println(dataInputStream.readUTF());
                System.out.println(dataInputStream.readInt() + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                    outputStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
