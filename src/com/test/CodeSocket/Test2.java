package com.test.CodeSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("Father");

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            //创建serversocket对象监听8899端口的连接请求
            Socket socket = serverSocket.accept();
            //接受客户端的请求，并创建一个Socket对象，用于与客户端进行通信
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //从Socket对象中获取输入流，然后使用BufferedReader对象读取输入流中的数据
            String info = null;
            while (true) {
                info = reader.readLine();
                System.out.println("recieve：" + info);
                if ("再见".equals(info)){
                    break;
                }
            }
            //读取到的数据会被输出到控制台上。如果读取到的数据是“再见”，程序会退出循环。

            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //从Socket对象中获取输出流，然后使用BufferedWriter对象向输出流中写入数据。
            writer.write("yeah!\n");
            writer.flush();
            writer.write("wait\n");
            writer.flush();
            writer.write("再见\n");
            writer.flush();
            //程序会向客户端发送三条消息：“yeah!”、“wait”和“再见”。

            System.out.println(socket.getPort());
            System.out.println(socket.getLocalPort());
            //输出Socket对象的端口号和本地端口号。
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
