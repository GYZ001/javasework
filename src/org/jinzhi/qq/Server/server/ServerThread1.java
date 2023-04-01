package org.jinzhi.qq.Server.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
//这个Java程序，代表了服务器端与客户端通信的线程。
// 当服务器端接受到客户端连接请求时，就会创建一个该类的实例，并在该实例中处理与该客户端的通信。
// 该线程类中的构造方法将创建与客户端的通信所需的输入输出流。run()方法是一个重载的线程函数，它在线程启动时自动调用。
// 在该方法中，线程将不断读取从客户端发送过来的信息，如果接收到的信息是“再见”，则线程将退出。如果发生异常，则会打印出堆栈跟踪。
public class ServerThread1 extends Thread {
    Socket socket = null;
    BufferedWriter writer = null;
    BufferedReader reader = null;

    public ServerThread1(Socket socket) {
        this.socket = socket;
        System.out.println("连接到一个客户端");
        try {
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String info = null;
        while (true){
            try {
                info = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("接收到的信息："+info);
            if ("再见".equals(info)){
                break;
            }
        }
        System.out.println("切断并收回该通讯管道。");
        System.out.println("当前UDP会话数目："+ (Thread.activeCount()-3));
    }
}

