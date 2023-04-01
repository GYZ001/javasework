package com.test.IO;

import java.io.*;

public class Test7 {
    public static void main(String[] args) {
        PrintStream out = null;
        out = System.err;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String info = null;

        try {
            while (true){
                info = reader.readLine();
                out.println(info);
                out.flush();
                if("拜拜".equals(info)){
                    System.out.println("再见");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (reader != null){
                    reader.close();
                    reader = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
