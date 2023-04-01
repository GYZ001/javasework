package com.test.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("./test.chm");
            out = new FileOutputStream("./c.chm");

            byte[] cache = new byte[1024];//大空间的缓存中介，提升单次数据传输效率
            int info = -2;
            while ((info = in.read(cache, 0, 1024)) != -1) {
                out.write(cache,0,cache.length);
                out.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
