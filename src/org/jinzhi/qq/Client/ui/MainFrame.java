package org.jinzhi.qq.Client.ui;

import org.jinzhi.qq.Client.component.ClinetImgCell;
import org.jinzhi.qq.Client.listener.UDPListener;
import org.jinzhi.qq.Client.listener.UDPThread;
import org.jinzhi.qq.Client.pub.CommonUse;
import org.jinzhi.qq.Client.pub.TCPSocket;
import org.jinzhi.qq.Client.pub.UDPSocket;
import org.jinzhi.qq.Server.bean.Qquser;
import org.jinzhi.qq.Server.pub.TCPMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame implements UDPListener {
    private TCPSocket tcpSocket = null;
    private UDPSocket udpSocket = null;

    private Qquser FullUser = null;

    private JPanel bodyPanel = null;
    private List<Qquser> friends = null;

    private JLabel nameLabel = null;//看得见
    private JList<Qquser> friendList = null;
    private DefaultListModel<Qquser> listModel = null;


    private Map<String, ChatFrame> chatmap = new HashMap<>();

    private List<Qquser> getFriends(Qquser qquser) {
        List<Qquser> friends = null;

        TCPMessage sMessage = new TCPMessage();//发送报文
        sMessage.setHead(CommonUse.FIND_FRIEND);
        sMessage.setBody(CommonUse.QQ_USER, qquser);

        TCPMessage rMessage = this.tcpSocket.submit(sMessage);//接收报文

        friends = (List<Qquser>) rMessage.getBody(CommonUse.FRIENDS_INFO);//报文体就是链表形式的对象

        return friends;

    }

    public void refreshlist() {
        List<Qquser> before = this.friends;//乱序
        List<Qquser> after = new ArrayList();//排序

        for (Qquser temp : before) {
            if ("1".equals(temp.getState())) {
                after.add(temp); //在线的先加入到after这个链表中
            }
        }
        for (Qquser temp : before) {
            if ("0".equals(temp.getState())) {
                after.add(temp);
            }
        }

        for (Qquser qquser : after) {
            if ("1".equals(qquser.getState())) {
                qquser.setPlace1("./onimg/" + qquser.getPic() + ".png");
            }
            if ("0".equals(qquser.getState())) {
                qquser.setPlace1("./outimg/" + qquser.getPic() + ".png");
            }
        }

        this.friends = after;//看不见的好友集合

        this.listModel = new DefaultListModel<Qquser>();//存储和管理元素集合的Swing组件
        for (Qquser qquser : friends) {
            this.listModel.addElement(qquser);
        }
        this.friendList.setModel(this.listModel);
    }

    private void createFriendList() {
        List<Qquser> before = this.getFriends(this.FullUser);//乱序
        List<Qquser> after = new ArrayList();//排序

        for (Qquser temp : before) {
            if ("1".equals(temp.getState())) {
                after.add(temp); //在线的先加入到after这个链表中
            }
        }
        for (Qquser temp : before) {
            if ("0".equals(temp.getState())) {
                after.add(temp);
            }
        }

        for (Qquser qquser : after) {
            if ("1".equals(qquser.getState())) {
                qquser.setPlace1("./onimg/" + qquser.getPic() + ".png");
            }
            if ("0".equals(qquser.getState())) {
                qquser.setPlace1("./outimg/" + qquser.getPic() + ".png");
            }
        }

        this.friends = after;//看不见的好友集合

        this.friendList = new JList<Qquser>();//看得见的显示集合的Swing组件
        this.friendList.setCellRenderer(new ClinetImgCell());
        this.listModel = new DefaultListModel<Qquser>();//存储和管理元素集合的Swing组件
        for (Qquser qquser : friends) {
            this.listModel.addElement(qquser);
        }
        this.friendList.setModel(this.listModel);
        //鼠标监听事件
        this.friendList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = friendList.getSelectedIndex();
                    Qquser qquser = listModel.getElementAt(index);
                    // 打开聊天界面
                    chatmap.put(qquser.getName(), openChatFrame(qquser, FullUser,udpSocket, chatmap));
                }
            }
        });
    }

    private ChatFrame openChatFrame(Qquser qquser,Qquser myuser, UDPSocket udpSocket, Map chatmap) {
        if (chatmap.get(qquser.getName()) != null) {
            return (ChatFrame)chatmap.get(qquser.getName());
        }
        ChatFrame chatFrame = new ChatFrame(qquser, myuser,this.udpSocket, this.chatmap);
        chatFrame.setBounds(300, 150, 400, 300);
        chatFrame.setVisible(true);
        return chatFrame;
    }

    private void init() {
        this.bodyPanel = (JPanel) this.getContentPane();
        this.bodyPanel.setLayout(new BorderLayout());

        this.nameLabel = new JLabel(this.FullUser.getName());
        this.bodyPanel.add(this.nameLabel, BorderLayout.NORTH);

        this.createFriendList();//生成好友列表
        this.bodyPanel.add(this.friendList, BorderLayout.CENTER);

        UDPThread udpThread = new UDPThread(this.udpSocket);
        udpThread.addUDPListener(this);
        udpThread.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(this.FullUser.getAccount() + "的主界面");
    }

    public MainFrame(TCPSocket tcpSocket, UDPSocket udpSocket, Qquser fullUser) {
        this.tcpSocket = tcpSocket;
        this.udpSocket = udpSocket;
        FullUser = fullUser;
        this.init();
    }

    @Override
    public void excute(String udpMessage) {
        String[] messages = udpMessage.split(CommonUse.UDP_PACKET_SYMBOL);
        String head = messages[0];

        if (CommonUse.ONLINE.equals(head)) {
            String account = messages[1];
            String ip = messages[2];
            String port = messages[3];

            System.out.println(messages);

            for (Qquser friend : this.friends) {
                if (account.equals(friend.getAccount())) {
                    friend.setState("1");
                    friend.setIp(ip);
                    friend.setPort(port);
                    break;
                }
            }
        } else if (CommonUse.OFFLINE.equals(head)) {
            String account = messages[1];

            for (Qquser friend : this.friends) {
                if (account.equals(friend.getAccount())) {
                    friend.setState("0");
                    break;
                }
            }
        }
        this.refreshlist();

        if ("message".equals(head)) {
            String Name = messages[1];
            String ip = messages[2];
            String port = messages[3];
            String info = messages[4];

            ChatFrame MyChatFrame = null;
            if (chatmap.get(Name) != null) {
                MyChatFrame = chatmap.get(Name);
            }else{
                Qquser qquser = new Qquser();
                qquser.setIp(ip);
                qquser.setName(Name);
                qquser.setPort(port);
                MyChatFrame = openChatFrame(qquser,FullUser,new UDPSocket(),chatmap);
                MyChatFrame.chatmap.put(Name,MyChatFrame);
            }
            MyChatFrame.reMessage(info);
        }
    }

}
