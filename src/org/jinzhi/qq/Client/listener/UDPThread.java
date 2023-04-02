package org.jinzhi.qq.Client.listener;

import org.jinzhi.qq.Client.pub.UDPSocket;

public class UDPThread extends Thread {
     private UDPSocket udpSocket = null;
     private UDPListener listener = null;

     public UDPThread(UDPSocket udpSocket){
         this.udpSocket = udpSocket;
     }

     public void  addUDPListener(UDPListener listener){
         this.listener = listener;
     }

    @Override
    public void run() {
        while (true){
            String sMessage = this.udpSocket.recieve();
            this.listener.excute(sMessage);
        }
    }
}
