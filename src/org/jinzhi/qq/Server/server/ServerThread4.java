package org.jinzhi.qq.Server.server;

import org.jinzhi.qq.Server.bean.Qquser;
import org.jinzhi.qq.Server.dao.QqUserDao;
import org.jinzhi.qq.Server.dao.QqUserDaoImpl;
import org.jinzhi.qq.Server.pub.CommonUse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread4 extends Thread {

    private Socket socket = null;
    private ObjectOutputStream out = null;
    private ObjectInputStream in =null;

    public boolean register(Qquser qquser){
        boolean flag = false;

        qquser.setState("0");
        qquser.setIp("0");
        qquser.setPort("0");

        QqUserDao qqUserDao = new QqUserDaoImpl();
        if (qqUserDao.save(qquser) > 0){
            flag = true;
        }
        return flag;
    }

    public ServerThread4(Socket socket){
        this.socket = socket;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            while (true){
                Qquser qquser = (Qquser)this.in.readObject();

                if (register(qquser)){
                    this.out.writeObject(CommonUse.SUCCESSFUL);
                } else {
                    this.out.writeObject(CommonUse.FAILURE);
                }
                this.out.flush();
            }
        } catch (IOException e) {
            System.out.println("一个客户端已经断开");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
