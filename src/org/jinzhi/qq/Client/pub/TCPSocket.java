package org.jinzhi.qq.Client.pub;

import org.jinzhi.qq.Server.pub.TCPMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPSocket {
    private Socket socket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;

    public TCPSocket(String ip,int port) {
        try {
            this.socket = new Socket(ip,port);
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TCPMessage submit(TCPMessage tcpMessage){
        TCPMessage tcpMessage1 = new TCPMessage();
        try {
            this.out.writeObject(tcpMessage);
            this.out.flush();

            tcpMessage1 = (TCPMessage)in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tcpMessage1;
    }

    public String getIp() {
        return this.socket.getLocalAddress().getHostAddress();
    }
}