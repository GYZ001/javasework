package org.jinzhi.qq.Client.ui;

import org.jinzhi.qq.Client.pub.CommonUse;
import org.jinzhi.qq.Client.pub.UDPSocket;
import org.jinzhi.qq.Server.bean.Qquser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

public class ChatFrame extends JFrame {

    private UDPSocket rudpSocket = null;
    private UDPSocket sudpSocket = null;
    private Qquser qquser = null;
    private Qquser myuser = null;
    public Map chatmap = null;


    private JTextArea messageArea; // 消息显示区域
    private JTextField inputField; // 输入框
    private JButton sendButton; // 发送按钮

    private void initUI() {
        // 消息显示区域
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // 输入框和发送按钮
        inputField = new JTextField();
        sendButton = new JButton("发送");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(inputField);
            }
        });

        // 布局
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void sendMessage(JTextField messsage) {
        String info = messsage.getText().trim();
        if (!info.isEmpty()) {
            sudpSocket.send("message" + CommonUse.UDP_PACKET_SYMBOL + this.myuser.getName()
                    + CommonUse.UDP_PACKET_SYMBOL + this.myuser.getIp() + CommonUse.UDP_PACKET_SYMBOL +
                    this.myuser.getPort() + CommonUse.UDP_PACKET_SYMBOL + info + CommonUse.UDP_PACKET_SYMBOL);
            messageArea.append("我：" + info + "\n");
            inputField.setText("");
        }
    }

    public void reMessage(String rmessage) {
        if (!rmessage.isEmpty()) {
            messageArea.append(qquser.getName() + "：" + rmessage + "\n");
        }
    }

    private void closeChat() {
        // 关闭聊天窗口
        dispose();
    }

    public ChatFrame(Qquser qquser,Qquser myuser,UDPSocket udpSocket, Map<String, ChatFrame> chatmap) {
        this.myuser = myuser;
        this.qquser = qquser;
        this.sudpSocket = new UDPSocket(qquser.getIp(), Integer.valueOf(qquser.getPort()));
        this.rudpSocket = new UDPSocket();
        this.chatmap = chatmap;

        setTitle("Chat with " + qquser.getName());
        setSize(480, 300);
        setLocationRelativeTo(null); // 窗口居中
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 设置窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 从map中删除键值对
                chatmap.remove(qquser.getName());
                dispose();
            }
        });
        initUI();
    }
}
