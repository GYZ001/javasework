package org.jinzhi.qq.Server.server;

import org.jinzhi.qq.Server.bean.Qquser;
import org.jinzhi.qq.Server.dao.QqUserDao;
import org.jinzhi.qq.Server.dao.QqUserDaoImpl;
import org.jinzhi.qq.Server.pub.CommonUse;
import org.jinzhi.qq.Server.pub.TCPMessage;
import org.jinzhi.qq.Server.pub.UDPSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerThread5 extends Thread {
    private Socket socket = null;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;

    private Qquser fullUser = null;
    private Qquser enduser = null;
//=============================================================================================================

    private List<Qquser> getFriends(String account) {
        List<Qquser> list = null;
        String sql = "select * from qquser where"
                + " account in (select friendAccount from friend where userAccount = '" + account + "')";
        list = new QqUserDaoImpl().findBySql(sql);
        return list;
    }

    private Qquser getFullUser(String account) {
        return new QqUserDaoImpl().findById(account);
    }
//===============================================================================================================
    private void updateDB(Qquser qquser) {
        QqUserDao dao = new QqUserDaoImpl();
        dao.update(qquser);
    }

    private void updateDBoff(Qquser qquser) {
        QqUserDao dao = new QqUserDaoImpl();
        dao.update(qquser);
    }

//=============================================================================================================

    private boolean checkUser(Qquser qquser) {
        String account = qquser.getAccount();
        String password = qquser.getPassword();

        QqUserDao dao = new QqUserDaoImpl();
        Qquser tempUser = dao.findById(account);
        if (tempUser != null && tempUser.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean register(Qquser qquser) {
        boolean flag = false;

        qquser.setState("0");
        qquser.setIp("0");
        qquser.setPort("0");

        QqUserDao qqUserDao = new QqUserDaoImpl();
        if (qqUserDao.save(qquser) > 0) {
            flag = true;
        }
        return flag;
    }

//=======================================================================================================================

    private void online(Qquser qquser) {
        List<Qquser> list = null;
        String sql = "select * from qquser where"
                + " account in (select friendAccount from friend where userAccount " +
                "= '" + qquser.getAccount() + "') and state = '1'";
        String sMessage = CommonUse.ONLINE + CommonUse.UDP_PACKET_SYMBOL + qquser.getAccount()
                + CommonUse.UDP_PACKET_SYMBOL + qquser.getIp() + CommonUse.UDP_PACKET_SYMBOL
                + qquser.getPort() + CommonUse.UDP_PACKET_SYMBOL;

        list = new QqUserDaoImpl().findBySql(sql);
        for (Qquser temp : list) {
            UDPSocket udpSocket = new UDPSocket(temp.getIp(), Integer.parseInt(temp.getPort()));
            udpSocket.send(sMessage);
        }
    }

    private void offline(Qquser qquser) {
        qquser.setIp("0");
        qquser.setPort("0");
        qquser.setState("0");
        List<Qquser> list = null;
        String sql = "select * from qquser where"
                + " account in (select friendAccount from friend where userAccount " +
                "= '" + qquser.getAccount() + "') and state = '1'";
        String sMessage = CommonUse.OFFLINE + CommonUse.UDP_PACKET_SYMBOL +
                qquser.getAccount() + CommonUse.UDP_PACKET_SYMBOL;

        list = new QqUserDaoImpl().findBySql(sql);
        for (Qquser temp : list) {
            UDPSocket udpSocket = new UDPSocket(temp.getIp(), Integer.parseInt(temp.getPort()));
            udpSocket.send(sMessage);
        }
    }

    private void shutSocket(){
        this.offline(enduser);
        this.updateDBoff(enduser);
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerThread5(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                TCPMessage tcpMessage = (TCPMessage) in.readObject();
                TCPMessage sMessage = new TCPMessage();
                if (CommonUse.REGISTER.equals(tcpMessage.getHead())) {

                    Qquser qquser = (Qquser) tcpMessage.getBody(CommonUse.QQ_USER);
                    if (this.register(qquser)) {
                        sMessage.setHead(CommonUse.SUCCESSFUL);
                    } else {
                        sMessage.setHead(CommonUse.FAILURE);
                    }

                } else if (CommonUse.LOGIN.equals(tcpMessage.getHead())) {
                    Qquser qquser = (Qquser) tcpMessage.getBody(CommonUse.QQ_USER);
                    this.enduser = qquser;
                    if (this.checkUser(qquser)) {
                        //改库
                        qquser.setState("1");
                        this.updateDB(qquser);
                        //得到完整用户
                        this.fullUser = (Qquser) this.getFullUser(qquser.getAccount());
                        sMessage.setBody(CommonUse.QQ_USER, this.fullUser);
                        //通知上线
                        this.online(this.fullUser);
                        System.out.println("通知上线成功");
                        sMessage.setHead(CommonUse.SUCCESSFUL);
                    } else {
                        sMessage.setHead(CommonUse.FAILURE);
                    }

                } else if (CommonUse.FIND_FRIEND.equals(tcpMessage.getHead())) {
                    Qquser tempUser = (Qquser) tcpMessage.getBody(CommonUse.QQ_USER);
                    sMessage.setBody(CommonUse.FRIENDS_INFO, this.getFriends(tempUser.getAccount()));
                }
                this.out.writeObject(sMessage);
                this.out.flush();
            }
        } catch (IOException e) {
            this.shutSocket();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
