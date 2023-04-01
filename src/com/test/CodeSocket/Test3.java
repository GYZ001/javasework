package com.test.CodeSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Son");

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            //创建了一个Socket对象，该对象连接到本地主机的端口号为8899的服务器。
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //创建了一个BufferedWriter对象，该对象将数据写入到Socket的输出流中。
            writer.write("Hello father\n");
            writer.flush();
            writer.write("1000 yuan\n");
            writer.flush();
            writer.write("再见\n");
            writer.flush();

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //创建了一个BufferedReader对象，该对象从Socket的输入流中读取数据。
            String info = null;
            while(true) {
                info = reader.readLine();
                System.out.println("recieve：" + info);
                if("再见".equals(info)) {
                    break;
                }
            }
            //从Socket的输入流中读取数据，并将其打印到控制台上，直到读取到"再见"为止。
            System.out.println(socket.getLocalPort());
            System.out.println(socket.getPort());
            //打印Socket的本地端口号和远程端口号
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
