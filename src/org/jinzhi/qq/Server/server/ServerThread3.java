package org.jinzhi.qq.Server.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.jinzhi.qq.Server.bean.Qquser;
import org.jinzhi.qq.Server.pub.CommonUse;

public class ServerThread3 extends Thread {
    Socket socket = null;
    ObjectInputStream in = null;
    ObjectOutputStream out = null;

    public ServerThread3(Socket socket) {
        this.socket = socket;
        try {
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public boolean check(Qquser qquser) {
        if ("莘莘学子".equals(qquser.getAccount()) && "123".equals(qquser.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

	@Override
	public void run() {
		try {
			Qquser qquser = (Qquser) in.readObject();
			if (check(qquser)){
				out.writeObject(CommonUse.SUCCESSFUL);
			}else {
				out.writeObject(CommonUse.FAILURE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
