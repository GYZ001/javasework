package org.jinzhi.qq.Server.server;

import org.jinzhi.qq.Server.pub.CommonUse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {

	public static void main(String[] args) {
		System.out.println("服务端启动");
		
		try {
			ServerSocket serverSocket = new ServerSocket(CommonUse.SERVER_PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread4 thread4 = new ServerThread4(socket);
				thread4.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
