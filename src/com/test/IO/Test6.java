package com.test.IO;

import java.io.*;

public class Test6 {
    public static void main(String[] args) {

        Student s1 = new Student("小王",17);

        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("./d.txt"));
            out.writeObject(s1);
            out.flush();

            in = new ObjectInputStream(new FileInputStream("./d.txt"));
            Student s = (Student)in.readObject();
            System.out.println(s.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null) {
                    out.close();
                    out = null;
                }
                if(in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
