package org.jinzhi.qq.Server.server;

import org.jinzhi.qq.Server.pub.CommonUse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5 {

	public static void main(String[] args) {
		System.out.println("服务器启动");
		
		try {
			ServerSocket serverSocket = new ServerSocket(CommonUse.SERVER_PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread5 thread5 = new ServerThread5(socket);
				thread5.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
