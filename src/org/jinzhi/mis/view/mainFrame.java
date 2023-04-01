package org.jinzhi.mis.view;

import org.jinzhi.mis.control.listener.MenuListener;
import org.jinzhi.mis.model.dao.MyMenuDAO;
import org.jinzhi.mis.model.dao.MyMenuDAOimpl;
import org.jinzhi.mis.model.entity.MyMenu;
import org.jinzhi.mis.model.entity.MyUser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//菜单生成方法
//一个界面绘制方法
//构造方法
public class mainFrame extends JFrame {

    private MyUser myUser = null;

    private JMenuBar menuBar = null;
    private JMenu helpmenu = null;
    private JMenuItem about = null;
    private JMenuItem content = null;

    private JPanel bodypanel = null;

    private JToolBar toolBar = null;
    private JLabel wellabel = null;
    private JLabel wellabelname = null;
    private JButton b1 = null;
    private JButton b2 = null;

    private JPanel panelwelcome = null;

    private JLabel labelside = null;

    public void CreatMenu() {
        MyMenuDAO menuDAO = new MyMenuDAOimpl();
        String sql = "select * from menu where menuId like '__'";
        List<MyMenu> list = menuDAO.findBySql(sql);

        for (MyMenu myMenu : list) {
            JMenu menu = new JMenu();
            menu.setActionCommand(myMenu.getMenuId());
            menu.setText(myMenu.getMenuName());
            menu.setToolTipText(myMenu.getMenuMemo());

            String sql1 = "select * from menu where menuId like '"+myMenu.getMenuId()+"__'";
            List<MyMenu> list2 = menuDAO.findBySql(sql1);
            for (MyMenu myMenu1 : list2) {
                JMenuItem item = new JMenuItem();
                item.setActionCommand(myMenu1.getMenuId());
                item.setText(myMenu1.getMenuName());
                item.setToolTipText(myMenu1.getMenuMemo());
                item.addActionListener(new MenuListener(this,myUser));
                menu.add(item);
            }
            this.menuBar.add(menu);
        }
    }

    public void init() {
        this.menuBar = new JMenuBar();
        this.helpmenu = new JMenu("Help");
        this.about = new JMenuItem("About");
        this.content = new JMenuItem("Content");
        this.helpmenu.add(this.about);
        this.helpmenu.add(this.content);
        this.CreatMenu();
        this.menuBar.add(this.helpmenu);
        this.setJMenuBar(this.menuBar);

        this.bodypanel = (JPanel)this.getContentPane();
        this.bodypanel.setLayout(new BorderLayout());

        this.toolBar = new JToolBar("Welcome");
        this.toolBar.setFloatable(false);
        this.toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.wellabel = new JLabel("Welcome You：");
        this.wellabelname = new JLabel();
        this.wellabelname.setText(this.myUser.getName());
        this.b1 = new JButton("quit");
        this.b2 = new JButton("Log back in");
        this.toolBar.add(wellabel);
        this.toolBar.add(wellabelname);
        this.toolBar.add(b1);
        this.toolBar.add(b2);
        this.bodypanel.add(this.toolBar,BorderLayout.NORTH);

        this.panelwelcome = new JPanelPhoto(2);
        this.panelwelcome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
        this.labelside = new JLabel("Student Status Management System V1.0",JLabel.CENTER);

        this.bodypanel.add(labelside,BorderLayout.SOUTH);
        this.bodypanel.add(panelwelcome,BorderLayout.CENTER);

        this.setTitle("Student Status Management System ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public mainFrame(MyUser myUser) {
        this.myUser = myUser;
        this.init();
    }

}
