package org.jinzhi.qq.Client.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.jinzhi.qq.Server.bean.Qquser;
import org.jinzhi.qq.Client.pub.CommonUse;

public class Client3 {

	public static void main(String[] args) {
		String back = null;
		try {
			Socket socket = new Socket(CommonUse.SERVER_IP,CommonUse.SERVER_PORT);

			BufferedReader sysreader = new BufferedReader(new InputStreamReader(System.in));

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			String info = sysreader.readLine();
			String[] infos = info.split("/");

			Qquser qquser = new Qquser();
			qquser.setAccount(infos[0]);
			qquser.setPassword(infos[1]);

			out.writeObject(qquser);
			out.flush();

			back = in.readObject().toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (CommonUse.SUCCESSFUL.equals(back)){
			System.out.println("登陆成功");
		}else {
			System.out.println("登陆失败");
		}
	}

}
