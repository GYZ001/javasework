package org.jinzhi.mis.view;

import org.jinzhi.mis.model.dao.MyUserDAO;
import org.jinzhi.mis.model.dao.MyUserDAOimpl;
import org.jinzhi.mis.model.entity.MyUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//一个检查用户规范的方法
//一个生成登录界面的方法
//空构造方法和主方法
//一个监听者方法
public class login extends JFrame implements ActionListener {

    private MyUser myUser = null;

    private JPanel p1 = null;//Demo
    private JPanel p2 = null;//Button list

    private JLabel titilelabel = null;
    private JLabel namelabel = null;
    private JLabel passwordlabel = null;

    private JTextField nameField = null;
    private JPasswordField passwordField = null;

    private JButton b1 = null;
    private JButton b2 = null;

    private boolean check(String name, String password) throws SQLException {
        Boolean flag = false;
        MyUserDAO user = new MyUserDAOimpl();
        MyUser myuser = user.selectMyUser(name);
        if (myuser != null && myuser.getPassword().equals(password)) {
            flag = true;
            this.myUser = myuser;
        }
        return flag;
    }

    public void init() {
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        GridBagLayout gb = new GridBagLayout();
        this.p1 = new JPanelPhoto(1);
        p1.setLayout(gb);
        con.add(p1, BorderLayout.CENTER);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        this.titilelabel = new JLabel("Login Demo Of Education System");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        this.p1.add(this.titilelabel, gridBagConstraints);

        this.namelabel = new JLabel("Name:");
        this.namelabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        this.p1.add(this.namelabel, gridBagConstraints);

        this.passwordlabel = new JLabel("Password:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        this.p1.add(this.passwordlabel, gridBagConstraints);

        this.nameField = new JTextField(16);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        this.p1.add(this.nameField, gridBagConstraints);

        this.passwordField = new JPasswordField(16);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        this.p1.add(this.passwordField, gridBagConstraints);

        this.p2 = new JPanel();
        this.p2.setLayout(new FlowLayout());
        this.b1 = new JButton("Submit");
        this.b1.addActionListener(this);
        this.b2 = new JButton("Cancel");
        this.b2.addActionListener(this);
        this.p2.add(b1);
        this.p2.add(b2);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        this.p1.add(this.p2, gridBagConstraints);

        this.setTitle("Customer Login Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public login() {
        init();
    }

    public static void main(String[] args) {
        login l1 = new login();
        l1.setBounds(600, 400, 350, 200);
        l1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String name = this.nameField.getText();
            String password = new String(this.passwordField.getPassword());

            if (name.length() < 0 || name == null || password == null || password.length() <= 0) {
                JOptionPane.showMessageDialog(this, "用户名或口令不能为空！");
                return;
            }
            try {
                if (this.check(name, password)) {
                    JOptionPane.showMessageDialog(this, "登录成功！");
                    mainFrame mainFrame = new mainFrame(this.myUser);
                    mainFrame.setBounds(500, 150, 800, 600);
                    mainFrame.setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == b2) {
            this.dispose();
        }

    }


}
