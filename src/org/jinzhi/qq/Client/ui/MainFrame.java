package org.jinzhi.qq.Client.ui;

import org.jinzhi.qq.Client.pub.CommonUse;
import org.jinzhi.qq.Client.pub.TCPSocket;
import org.jinzhi.qq.Server.bean.Qquser;
import org.jinzhi.qq.Server.pub.TCPMessage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    TCPSocket tcpSocket = null;
    Qquser FullUser = null;

    private JPanel bodyPanel = null;
    private List<Qquser> friends = null;

    private JLabel nameLabel = null;//看得见
    private JList<Qquser> friendList = null;
    private DefaultListModel<Qquser> listModel = null;

    private List<Qquser> getFriends(Qquser qquser){
        List<Qquser> friends = null;

        TCPMessage sMessage = new TCPMessage();//发送报文
        sMessage.setHead(CommonUse.FIND_FRIEND);
        sMessage.setBody(CommonUse.QQ_USER, qquser);

        TCPMessage rMessage = this.tcpSocket.submit(sMessage);//接收报文

        friends = (List<Qquser>)rMessage.getBody(CommonUse.FRIENDS_INFO);//报文体就是链表形式的对象

        return friends;

    }

    private void createFriendList(){
        List<Qquser> before = this.getFriends(this.FullUser);//乱序
        List<Qquser> after = new ArrayList();//排序

        for (Qquser temp : before) {
            if("1".equals(temp.getState())) {
                after.add(temp); //在线的先加入到after这个链表中
            }
        }
        for (Qquser temp : before) {
            if("0".equals(temp.getState())) {
                after.add(temp);
            }
        }

        this.friends = after;//看不见的好友集合

        this.friendList = new JList<Qquser>();//看得见的显示集合的Swing组件
        this.listModel = new DefaultListModel<Qquser>();//存储和管理元素集合的Swing组件
        for (Qquser qquser : friends) {
            this.listModel.addElement(qquser);
        }
        this.friendList.setModel(this.listModel);
    }

    private void init(){
        this.bodyPanel = (JPanel)this.getContentPane();
        this.bodyPanel.setLayout(new BorderLayout());

        this.nameLabel = new JLabel(this.FullUser.getName());
        this.bodyPanel.add(this.nameLabel, BorderLayout.NORTH);

        this.createFriendList();//生成好友列表
        this.bodyPanel.add(this.friendList, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(this.FullUser.getAccount() + "的主界面");
    }

    public MainFrame(TCPSocket tcpSocket, Qquser fullUser) {
        this.tcpSocket = tcpSocket;
        FullUser = fullUser;
        this.init();
    }
}
