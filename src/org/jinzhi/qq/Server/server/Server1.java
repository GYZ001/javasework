package org.jinzhi.qq.Server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.jinzhi.qq.Server.pub.CommonUse;
//		这个Java程序，代表了一个Socket通信系统的服务器端。
//		该程序启动后，将创建一个ServerSocket实例，该实例将监听在CommonUse类中指定的端口号上，等待客户端的连接请求。
//		一旦有客户端连接请求到达，服务器将接受请求并创建一个新的线程来处理与该客户端的通信。
//		然后，服务器将继续等待其他客户端的连接请求。如果发生异常，则会打印出堆栈跟踪。
public class Server1 {

	public static void main(String[] args) {
		System.out.println("服务器启动");
		try {
			ServerSocket serverSocket = new ServerSocket(CommonUse.SERVER_PORT);
			while (true){
				Socket socket = serverSocket.accept();
				ServerThread1 serverThread1 = new ServerThread1(socket);
				serverThread1.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
