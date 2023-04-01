package com.test.CodeSocket;

import java.io.IOException;
import java.net.*;
//这段Java代码定义了一个main方法，用UDP协议从另一个程序接收一条消息
public class Test5 {
    public static void main(String[] args) {
        System.out.println("接收端启动");

        try {
            DatagramSocket socket = new DatagramSocket(9988);
            //创建一个DatagramSocket对象，绑定到9988端口，可以通过网络发送和接收数据报。
            byte[] pool = new byte[1024];
            //创建一个大小为1024的字节数组，用来存储接收到的数据。
            DatagramPacket packet = new DatagramPacket(pool, 0, pool.length);
            //创建一个DatagramPacket对象，包装字节数组，指定数据的长度和存储位置。
            socket.receive(packet);
            //ͨ通过套接字从网络上接收一个数据报，并将其存储到数据包中。

            String info = new String(packet.getData());
            //从数据包中获取数据，并转换为字符串形式。
            System.out.println("接收到的信息："+info);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
