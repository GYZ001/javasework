package org.jinzhi.qq.Server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.jinzhi.qq.Server.pub.CommonUse;

public class Server3 {

	public static void main(String[] args) {
		System.out.println("服务端启动");
		
		try {
			ServerSocket serverSocket = new ServerSocket(CommonUse.SERVER_PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread3 thread3 = new ServerThread3(socket);
				thread3.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}