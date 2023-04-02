package org.jinzhi.qq.Client.ui;

import org.jinzhi.qq.Client.pub.UDPSocket;
import org.jinzhi.qq.Server.bean.Qquser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatFrame extends JFrame implements ActionListener {
    private UDPSocket udpSocket = null;
    private Qquser qquser = null;


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
                sendMessage();
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

    private void sendMessage() {

    }

    private void closeChat() {
        // 关闭聊天窗口
        dispose();
    }


    public ChatFrame(Qquser qquser, UDPSocket udpSocket) {
        this.qquser = qquser;
        this.udpSocket = udpSocket;

        setTitle("Chat with " + qquser.getName());
        setSize(480, 300);
        setLocationRelativeTo(null); // 窗口居中

        // 设置窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeChat();
            }
        });

        initUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
