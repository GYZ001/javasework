package org.jinzhi.mis.control.listener;

import org.jinzhi.mis.model.dao.FunctionDAO;
import org.jinzhi.mis.model.dao.FunctionDAOimpl;
import org.jinzhi.mis.model.entity.Function;
import org.jinzhi.mis.model.entity.MyUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuListener implements ActionListener {
    private JFrame mainfram = null;

    private MyUser myUser = null;

    private JPanel panelBody = null;
    private JPanel welpanel = null;
    private JPanel leftpanel = null;
    private JPanel eastpanel = null;
    private JPanel toppanel = null;

    private JPanel getpaneltop(String menuid) {
        JPanel panel = new JPanel(new GridLayout(6,1));
        FunctionDAO functionDAO = new FunctionDAOimpl();
        List<Function> functionList = functionDAO.findByMenuIdAndRoleId(menuid,this.myUser.getRoleId());
        for (Function function : functionList){
            JButton b1 = new JButton(function.getName());
            b1.setActionCommand(function.getId());
            b1.setToolTipText(function.getMemo());
            b1.addActionListener(new FunctionListener(this.mainfram));
            panel.add(b1);
        }

        return panel;
    }

    public MenuListener(JFrame mainfram,MyUser myUser) {
        this.myUser = myUser;
        this.mainfram = mainfram;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.panelBody = (JPanel)this.mainfram.getContentPane();
        this.panelBody.remove(2);
        this.welpanel = new JPanel();
        this.welpanel.setLayout(new BorderLayout());
        this.welpanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.BLACK));
        this.panelBody.repaint();
        this.panelBody.add(welpanel,BorderLayout.CENTER);

        this.toppanel = this.getpaneltop(e.getActionCommand());
        this.leftpanel = new JPanel(new BorderLayout());
        this.leftpanel.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
        this.leftpanel.add(this.toppanel,BorderLayout.NORTH);
        this.welpanel.add(this.leftpanel,BorderLayout.WEST);

        this.eastpanel = new JPanel(new BorderLayout());
        this.welpanel.add(this.eastpanel,BorderLayout.CENTER);
        this.welpanel.updateUI();
        this.welpanel.repaint();
        this.mainfram.setVisible(true);
    }




}
