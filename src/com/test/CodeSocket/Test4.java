package com.test.CodeSocket;

import java.io.IOException;
import java.net.*;
//定义了一个main方法，用UDP协议向另一个程序发送一条消息
public class Test4 {
    public static void main(String[] args) {
        System.out.println("发送端启动");

        DatagramSocket socket = null;
        DatagramPacket packet = null;

        try {
            socket = new DatagramSocket();
            //创建一个DatagramSocket对象，可以通过网络发送和接收数据报
            byte[] pool = new byte[1024];
            //创建一个大小为1024的字节数组，用来存储要发送的数据。
            packet = new DatagramPacket(pool, 0, pool.length, InetAddress.getByName("127.0.0.1"), 9988);
            //创建一个DatagramPacket对象，包装字节数组，指定数据的长度，目标地址（127.0.0.1）和端口（9988）。
            packet.setData("你好，我是发送端".getBytes());
            //设置数据报的内容为"你好，我是发送者"的字节形式。
            socket.send(packet);
            //ͨ通过套接字将数据报发送到目标地址。
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
