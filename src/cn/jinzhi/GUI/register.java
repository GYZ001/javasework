package cn.jinzhi.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class register extends JFrame implements ActionListener {

    private JPanel allpanel = null;
    private JPanel sexpanel = null;
    private JPanel habitpanel = null;
    private JPanel buttonpanel = null;
    private JPanel buttonpane2 = null;

    private JScrollPane pane = null;

    private JLabel titlelabel = null;
    private JLabel namelabel = null;
    private JLabel passlabel1 = null;
    private JLabel passlabel2 = null;
    private JLabel sexlabel = null;
    private JLabel habitlabel = null;
    private JLabel fromlabel = null;
    private JLabel Describe = null;

    private ButtonGroup buttonGroup = null;

    private JTextField namefiled = null;
    private JPasswordField passwordField1 = null;
    private JPasswordField passwordField2 = null;

    private JButton sub = null;
    private JButton clear = null;
    private JButton dele = null;
    private JButton upd = null;
    private JButton sear = null;
    private JRadioButton boybutton = null;
    private JRadioButton girlbutton = null;
    private JCheckBox singbutton = null;
    private JCheckBox dancebutton = null;
    private JCheckBox rapbutton = null;
    private JCheckBox basketballbutton = null;
    private JComboBox<String> frombox = null;

    private JTextArea DescribeMyself = null;

    private GridBagLayout Layout = null;
    private GridBagConstraints constraints = null;

    private void init() {
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        this.Layout = new GridBagLayout();
        this.allpanel = new JPanel(Layout);
        this.allpanel.setBackground(Color.cyan);
        con.add(this.allpanel, BorderLayout.CENTER);

        this.constraints = new GridBagConstraints();
        this.titlelabel = new JLabel("学员注册系统", JLabel.CENTER);
        this.constraints.gridy = 0;
        this.constraints.gridx = 1;
        this.allpanel.add(this.titlelabel, this.constraints);

        this.constraints.anchor = GridBagConstraints.EAST;

        this.namelabel = new JLabel("Name:");
        this.constraints.gridy = 1;
        this.constraints.gridx = 0;
        this.allpanel.add(this.namelabel, this.constraints);

        this.passlabel1 = new JLabel("Pass1:");
        this.constraints.gridy = 2;
        this.constraints.gridx = 0;
        this.allpanel.add(this.passlabel1, this.constraints);

        this.passlabel2 = new JLabel("Pass2:");
        this.constraints.gridy = 3;
        this.constraints.gridx = 0;
        this.allpanel.add(this.passlabel2, this.constraints);

        this.sexlabel = new JLabel("Sex:");
        this.constraints.gridy = 4;
        this.constraints.gridx = 0;
        this.allpanel.add(this.sexlabel, this.constraints);

        this.habitlabel = new JLabel("Habit:");
        this.constraints.gridy = 5;
        this.constraints.gridx = 0;
        this.allpanel.add(this.habitlabel, this.constraints);


        this.fromlabel = new JLabel("Native Place:");
        this.constraints.gridy = 6;
        this.constraints.gridx = 0;
        this.allpanel.add(this.fromlabel, this.constraints);

        this.Describe = new JLabel("Describe you:");
        this.constraints.gridy = 7;
        this.constraints.gridx = 0;
        this.allpanel.add(this.Describe, this.constraints);

        this.namefiled = new JTextField(18);
        this.constraints.gridy = 1;
        this.constraints.gridx = 1;
        this.allpanel.add(this.namefiled, this.constraints);

        this.passwordField1 = new JPasswordField(18);
        this.constraints.gridy = 2;
        this.constraints.gridx = 1;
        this.allpanel.add(this.passwordField1, this.constraints);

        this.passwordField2 = new JPasswordField(18);
        this.constraints.gridy = 3;
        this.constraints.gridx = 1;
        this.allpanel.add(this.passwordField2, this.constraints);

        this.sexpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        this.sexpanel.setBackground(Color.cyan);
        this.boybutton = new JRadioButton("man");
        this.boybutton.setBackground(Color.cyan);
        this.girlbutton = new JRadioButton("girl");
        this.girlbutton.setBackground(Color.cyan);

        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(boybutton);
        this.buttonGroup.add(girlbutton);

        this.sexpanel.add(boybutton);
        this.sexpanel.add(girlbutton);

        this.constraints.gridy = 4;
        this.constraints.gridx = 1;
        this.allpanel.add(this.sexpanel, this.constraints);


        this.singbutton = new JCheckBox("唱");
        this.dancebutton = new JCheckBox("跳");
        this.rapbutton = new JCheckBox("rap");
        this.basketballbutton = new JCheckBox("篮球");
        this.singbutton.setBackground(Color.cyan);
        this.dancebutton.setBackground(Color.cyan);
        this.rapbutton.setBackground(Color.cyan);
        this.basketballbutton.setBackground(Color.cyan);

        this.habitpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.habitpanel.setBackground(Color.cyan);
        this.habitpanel.add(singbutton);
        this.habitpanel.add(dancebutton);
        this.habitpanel.add(rapbutton);
        this.habitpanel.add(basketballbutton);
        this.constraints.gridy = 5;
        this.constraints.gridx = 1;
        this.allpanel.add(this.habitpanel, this.constraints);

        this.frombox = new JComboBox<String>(new String[]{"Xian", "BeiJing", "ShangHai"});
        this.frombox.setPreferredSize(new Dimension(200, 25));
        this.constraints.gridy = 6;
        this.constraints.gridx = 1;
        this.allpanel.add(this.frombox, this.constraints);

        this.DescribeMyself = new JTextArea("Describe yourself!", 10, 18);
        this.DescribeMyself.setLineWrap(true);
        this.pane = new JScrollPane();
        this.pane.getViewport().add(DescribeMyself);
        this.constraints.gridy = 7;
        this.constraints.gridx = 1;
        this.allpanel.add(this.pane, this.constraints);

        this.buttonpanel = new JPanel();
        this.buttonpane2 = new JPanel();
        this.buttonpanel.setBackground(Color.cyan);
        this.buttonpane2.setBackground(Color.cyan);
        this.sub = new JButton("Submit");
        this.sub.addActionListener(this);
        this.clear = new JButton("Clear");
        this.clear.addActionListener(this);
        this.dele = new JButton("Delete");
        this.dele.addActionListener(this);
        this.upd = new JButton("Update");
        this.upd.addActionListener(this);
        this.sear = new JButton("Search");
        this.sear.addActionListener(this);
        this.buttonpanel.add(sub);
        this.buttonpanel.add(clear);
        this.buttonpane2.add(dele);
        this.buttonpane2.add(upd);
        this.buttonpane2.add(sear);
        this.constraints.gridy = 8;
        this.constraints.gridx = 1;
        this.allpanel.add(this.buttonpanel, this.constraints);
        this.constraints.gridy = 9;
        this.constraints.gridx = 1;
        this.allpanel.add(this.buttonpane2, this.constraints);


        this.setTitle("register demo");
        this.setBounds(50, 50, 400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public register() {
        this.init();
    }

    public static void main(String[] args) {
        new register();
    }

    public void reset() {

        this.namefiled.setText("");
        this.passwordField1.setText("");
        this.passwordField2.setText("");
        this.boybutton.setSelected(true);
        this.singbutton.setSelected(false);
        this.dancebutton.setSelected(false);
        this.rapbutton.setSelected(false);
        this.basketballbutton.setSelected(false);
        this.frombox.setSelectedItem("Xian");
        this.DescribeMyself.setText("Describe yourself!");


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String name = this.namefiled.getText();
        String password = new String(this.passwordField1.getPassword());
        String password2 = new String(this.passwordField2.getPassword());
        String sex = null;
        String sing = null;
        String dance = null;
        String rap = null;
        String basketball = null;
        String place = null;
        String describe = null;
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:Mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=gbk";
        String musername = "root";
        String mpassword = "123456";
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        if (this.boybutton.isSelected()) {
            sex = this.boybutton.getText();
        } else if (this.girlbutton.isSelected()) {
            sex = this.girlbutton.getText();
        }

        if (this.singbutton.isSelected()) {
            sing = this.singbutton.getText();
        }

        if (this.dancebutton.isSelected()) {
            dance = this.dancebutton.getText();
        }

        if (this.rapbutton.isSelected()) {
            rap = this.rapbutton.getText();
        }

        if (this.basketballbutton.isSelected()) {
            basketball = this.basketballbutton.getText();
        }

        place = this.frombox.getSelectedItem().toString();
        describe = this.DescribeMyself.getText();


        if (e.getSource() == this.sub) {

            if (name == null || name.length() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "用户名不能为空", "用户名提示", JOptionPane.ERROR_MESSAGE);
                return;
            }


            try {
                Class.forName(Driver);//加载驱动
                con = DriverManager.getConnection(url, musername, mpassword);//访问数据库，建立连接

                statement = con.createStatement();//java获取执行对象
                //修改、添加和删除只需要修改sql,执行executeUpdate方法

                String sql = "insert into test (name,password,sex,sing,dance,rap,basketball,place,des) values('" + name + "','" + password + "','" + sex + "','" + sing + "','" + dance + "','" + rap + "','" + basketball + "','" + place + "','" + describe + "')";


                int i = statement.executeUpdate(sql);

                if (i > 0) {
                    JOptionPane.showMessageDialog(this,
                            "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    reset();
                    return;

                } else {
                    JOptionPane.showMessageDialog(this,
                            "添加失败", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } catch (SQLException | ClassNotFoundException er) {

                JOptionPane.showMessageDialog(this,
                        "添加失败,用户名重复", "提示", JOptionPane.ERROR_MESSAGE);
                return;

            } finally {

                try {
                    if (statement != null) {

                        statement.close();
                        statement = null;
                    }
                } catch (SQLException er) {
                    System.out.println("statement释放异常");
                }

                try {
                    if (con != null) {

                        con.close();
                        con = null;
                    }
                } catch (SQLException er) {
                    System.out.println("con释放异常");
                }

            }


        } else if (e.getSource() == this.clear) {

            reset();
            JOptionPane.showMessageDialog(this, "清空成功");
            return;


        } else if (e.getSource() == this.dele) {


            try {
                Class.forName(Driver);//加载驱动
                con = DriverManager.getConnection(url, musername, mpassword);//访问数据库，建立连接

                statement = con.createStatement();//java获取执行对象
                //修改、添加和删除只需要修改sql,执行update方法

                //String sql = "insert into test (name,sex,password,sing,dance,rap,basketball,place,des) values('"+name+"','"+password+"','"+sex+"','"+sing+"','"+dance+"','"+rap+"','"+basketball+"','"+place+"','"+describe+"')";
                //String sql = "insert into test (name,sex) values ('"+name+"','"+sex+"')";
                String sql = "delete from test where name = '" + name + "'";
                //String sql3 = "update test set name = '张三' where id = '001'";

                int i = statement.executeUpdate(sql);

                if (i > 0) {
                    JOptionPane.showMessageDialog(this,
                            "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    reset();
                    return;

                } else {
                    JOptionPane.showMessageDialog(this,
                            "删除失败", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } catch (SQLException | ClassNotFoundException er) {

                JOptionPane.showMessageDialog(this,
                        "删除失败", "提示", JOptionPane.ERROR_MESSAGE);
                return;

            } finally {

                try {
                    if (statement != null) {

                        statement.close();
                        statement = null;
                    }
                } catch (SQLException er) {
                    System.out.println("statement释放异常");
                }

                try {
                    if (con != null) {

                        con.close();
                        con = null;
                    }
                } catch (SQLException er) {
                    System.out.println("con释放异常");
                }

            }

        } else if (e.getSource() == this.upd) {

            try {
                Class.forName(Driver);//加载驱动
                con = DriverManager.getConnection(url, musername, mpassword);//访问数据库，建立连接

                statement = con.createStatement();//java获取执行对象
                //修改、添加和删除只需要修改sql,执行update方法

                //String sql = "insert into test (name,sex,password,sing,dance,rap,basketball,place,des) values('"+name+"','"+password+"','"+sex+"','"+sing+"','"+dance+"','"+rap+"','"+basketball+"','"+place+"','"+describe+"')";
                //String sql = "insert into test (name,sex) values ('"+name+"','"+sex+"')";
                //String sql = "delete from test where name = '"+name+"'";
                String sql = "update test set sex = '" + sex + "',password = '" + password + "',sing = '" + sing + "',dance = '" + dance + "',rap = '" + rap + "',basketball = '" + basketball + "',place = '" + place + "',des = '" + describe + "' where name = '" + name + "'";

                int i = statement.executeUpdate(sql);

                if (i > 0) {
                    JOptionPane.showMessageDialog(this,
                            "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    reset();
                    return;

                } else {
                    JOptionPane.showMessageDialog(this,
                            "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } catch (SQLException | ClassNotFoundException er) {

                JOptionPane.showMessageDialog(this,
                        "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
                return;

            } finally {

                try {
                    if (statement != null) {

                        statement.close();
                        statement = null;
                    }
                } catch (SQLException er) {
                    System.out.println("statement释放异常");
                }

                try {
                    if (con != null) {

                        con.close();
                        con = null;
                    }
                } catch (SQLException er) {
                    System.out.println("con释放异常");
                }

            }


        } else if (e.getSource() == this.sear) {

            try {
                Class.forName(Driver);//加载驱动
                con = DriverManager.getConnection(url, musername, mpassword);//访问数据库，建立连接

                statement = con.createStatement();//java获取执行对象
                String sql = "SELECT * FROM test where name = '" + name + "'";
                resultSet = statement.executeQuery(sql);//java执行sql语句，并返回结果

                while (resultSet.next()) {
                    sex = resultSet.getString("sex");
                    password = resultSet.getString("password");
                    sing = resultSet.getString("sing");
                    dance = resultSet.getString("dance");
                    rap = resultSet.getString("rap");
                    basketball = resultSet.getString("basketball");
                    describe = resultSet.getString("des");

                    place = resultSet.getString("place");
                }

                this.passwordField1.setText(password);
                this.passwordField2.setText(password);
                if ("man".equals(sex)) {
                    this.boybutton.setSelected(true);
                } else if ("girl".equals(sex)) {
                    this.girlbutton.setSelected(true);
                }
                if (sing.length() <= 0) {
                    this.singbutton.setSelected(false);
                } else {
                    this.singbutton.setSelected(true);
                }

                System.out.println(sing.toString());

                if (dance.length() <= 0) {
                    this.dancebutton.setSelected(false);
                } else {
                    this.dancebutton.setSelected(true);
                }

                if (rap.length() <= 0) {
                    this.rapbutton.setSelected(false);
                } else {
                    this.rapbutton.setSelected(true);
                }

                if (basketball.length() <= 0) {
                    this.basketballbutton.setSelected(false);
                } else {
                    this.basketballbutton.setSelected(true);
                }

                this.frombox.setSelectedItem(place);

                this.DescribeMyself.setText(describe);


                if (sex != null) {
                    JOptionPane.showMessageDialog(this,
                            "查询成功");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this,
                            "查无此人", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }


            } catch (SQLException | ClassNotFoundException es) {

                JOptionPane.showMessageDialog(this,
                        "查无此人", "提示", JOptionPane.ERROR_MESSAGE);
                return;

            } finally {

                try {
                    if (resultSet != null) {

                        resultSet.close();
                        resultSet = null;
                    }
                } catch (SQLException es) {
                    System.out.println("resultSet释放异常");
                }

                try {
                    if (statement != null) {

                        statement.close();
                        statement = null;
                    }
                } catch (SQLException es) {
                    System.out.println("statement释放异常");
                }

                try {
                    if (con != null) {

                        con.close();
                        con = null;
                    }
                } catch (SQLException es) {
                    System.out.println("con释放异常");
                }

            }

        }

    }
}
