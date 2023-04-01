package org.jinzhi.qq.Server.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.jinzhi.qq.Server.pub.CommonUse;

public class ServerThread2 extends Thread {
	Socket socket = null;
	BufferedWriter writer = null;
	BufferedReader reader = null;

	public ServerThread2(Socket socket) {
		this.socket = socket;
		try {
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String[] infos = new String[2];
		try {
			infos[0] = reader.readLine();
			infos[1] = reader.readLine();

			if ("莘莘学子".equals(infos[0]) && "123".equals(infos[1])){
				writer.write(CommonUse.SUCCESSFUL+"\n");
				writer.flush();
			}else{
				writer.write(CommonUse.FAILURE+"\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
