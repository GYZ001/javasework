package cn.jinzhi.DBGUI;

import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MyFrame extends JFrame implements ActionListener {

    private JMenuBar menu = null;
    private JMenu filemenu = null;
    private JMenuItem newfile = null;
    private JMenuItem openfile = null;
    private JMenu editmenu = null;
    private JMenuItem undo = null;

    private JToolBar tb = null;
    private JButton b1 = null;
    private JButton b2 = null;
    private JButton b3 = null;
    private JButton b4 = null;
    private JButton b5 = null;

    private JTabbedPane jtp1 = null;
    private JPanel bodypane = null;//显示
    private JPanel p1 = null;//显示
    private JPanel p2 = null;//功能板
    private JPanel p3 = null;//数据
    private JPanel p4 = null;
    private JTabbedPane tabbedPane = null;

    private JTextField id = null;
    private JTextField name = null;
    private JTextField sex = null;
    private JTextField place = null;

    private JLabel idl = null;
    private JLabel namel = null;
    private JLabel sexl = null;
    private JLabel placel = null;


    private JScrollPane scrollPane1 = null;
    private JTable table1 = null;
    private DefaultTableModel tableModel1 = null;
    private String[][] data = null;
    private String[] title = null;
    private JButton button1 = null;
    private GridBagConstraints constraints = null;
    private GridBagConstraints constraints1 = null;

    DBmodel d1 = new DBmodel();

    private String[][] getData(String sql) throws ClassNotFoundException, SQLException {
        int i = 0;
        ResultSet resultSet = d1.find(sql);
        while (resultSet.next()){
            i++;
        }
        String array[][] = new String[i][4];
        resultSet = d1.find(sql);//java执行sql语句，并返回结果
        for (int k = 0; resultSet.next(); k++) {
            array[k][0] = resultSet.getString("id");
            array[k][1] = resultSet.getString("name");
            array[k][2] = resultSet.getString("sex");
            array[k][3] = resultSet.getString("place");
        }
        return array;
    }

    private void init(String sql) {
        this.constraints = new GridBagConstraints();
        this.constraints1 = new GridBagConstraints();

        this.menu = new JMenuBar();
        this.filemenu = new JMenu("file");
        this.newfile = new JMenuItem("new");
        this.newfile.addActionListener(this);
        this.openfile = new JMenuItem("open");
        this.filemenu.add(this.newfile);
        this.filemenu.add(new JSeparator());
        this.filemenu.add(this.openfile);
        this.menu.add(this.filemenu);
        this.editmenu = new JMenu("edit");
        this.editmenu.setEnabled(false);
        this.undo = new JMenuItem("undo");
        this.editmenu.add(this.undo);
        this.menu.add(this.editmenu);
        this.setJMenuBar(this.menu);

        this.bodypane = (JPanel)this.getContentPane();
        this.p1 = new JPanel();
        p1.setLayout(new GridBagLayout());

        this.tb = new JToolBar("toolbar");
        this.tb.setFloatable(false);
        this.b1 = new JButton("增加");
        b1.addActionListener(this);
        this.b2 = new JButton("删除");
        b2.addActionListener(this);
        this.b3 = new JButton("修改");
        b3.addActionListener(this);
        this.b4 = new JButton("查询");
        b4.addActionListener(this);
        this.b5 = new JButton("刷新");
        b5.addActionListener(this);
        this.tb.add(b1);
        this.tb.add(b2);
        this.tb.add(b3);
        this.tb.add(b4);
        this.tb.add(b5);
        this.tb.setFloatable(true);
        this.bodypane.add(this.tb, BorderLayout.NORTH);

        this.p2 = new JPanel(new GridBagLayout());
        this.p2.setBackground(Color.GREEN);
        idl = new JLabel("编号");
        this.constraints1.gridx = 0;
        this.constraints1.gridy = 0;
        this.p2.add(idl,this.constraints1);
        namel = new JLabel("姓名");
        this.constraints1.gridx = 1;
        this.constraints1.gridy = 0;
        this.p2.add(namel,this.constraints1);
        sexl = new JLabel("性别");
        this.constraints1.gridx = 2;
        this.constraints1.gridy = 0;
        this.p2.add(sexl,this.constraints1);
        placel = new JLabel("城市");
        this.constraints1.gridx = 3;
        this.constraints1.gridy = 0;
        this.p2.add(placel,this.constraints1);
        id = new JTextField(8);
        name = new JTextField(6);
        sex = new JTextField(4);
        place = new JTextField(18);
        this.constraints1.gridx = 0;
        this.constraints1.gridy = 1;
        this.p2.add(id,this.constraints1);
        this.constraints1.gridx = 1;
        this.constraints1.gridy = 1;
        this.p2.add(name,this.constraints1);
        this.constraints1.gridx = 2;
        this.constraints1.gridy = 1;
        this.p2.add(sex,this.constraints1);
        this.constraints1.gridx = 3;
        this.constraints1.gridy = 1;
        this.p2.add(place,this.constraints1);
        this.constraints.fill = GridBagConstraints.BOTH;
        this.constraints.gridy = 1;
        this.constraints.weightx = 1;
        this.constraints.weighty = 2;
        this.p1.add(p2,this.constraints);
        DBview(sql);
        this.p4 = new JPanelPhoto();
        this.tabbedPane = new JTabbedPane();
        this.tabbedPane.add("操作",this.p1);
        this.tabbedPane.add("介绍",this.p4);
        bodypane.add(this.tabbedPane,BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("人事管理系统");

    }

    private void DBview(String sql) {
        try {
            this.p3 = new JPanel(new BorderLayout());
            p3.setBackground(Color.CYAN);
            this.data = this.getData(sql);
            this.title = new String[]{"id", "name", "sex","place"};
            this.tableModel1 = new DefaultTableModel(this.data, this.title);
            this.table1 = new JTable(this.tableModel1);
            this.scrollPane1 = new JScrollPane(this.table1);
            this.constraints.fill = GridBagConstraints.BOTH;
            this.constraints.gridy = 2;
            this.constraints.weightx = 1;
            this.constraints.weighty = 17;
            this.p1.add(scrollPane1,this.constraints);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reset(String sql){
        this.bodypane.removeAll();
        this.bodypane.updateUI();
        init(sql);
    }

    public MyFrame() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM myuser";
        this.init(sql);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyFrame m1 = new MyFrame();
        m1.setBounds(100, 50, 800, 600);
        m1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cid = this.id.getText();
        String cname = this.name.getText();
        String csex = this.sex.getText();
        String cplace = this.place.getText();

        if (e.getSource() == this.b1){
            if (cid == null || cid.length() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "id不能为空", "id提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String sql = "insert into myuser (id,name,sex,place) values('" + cid + "','" + cname + "','" + csex + "','" + cplace  + "')";
                int i = d1.update(sql);

                if (i > 0) {
                    JOptionPane.showMessageDialog(this,
                            "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);

                    String sql1 = "SELECT * FROM myuser";
                    reset(sql1);
                    return;

                } else {
                    JOptionPane.showMessageDialog(this,
                            "添加失败", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "添加失败", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }else if(e.getSource() == this.b2){
            if (cid == null || cid.length() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "id不能为空", "id提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sql = "delete from myuser where id = '" + cid + "'";
            try {
                int i = d1.update(sql);
                if (i > 0) {
                    JOptionPane.showMessageDialog(this,
                            "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    String sql1 = "SELECT * FROM myuser";
                    reset(sql1);
                    return;

                } else {
                    JOptionPane.showMessageDialog(this,
                            "删除失败", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "删除失败", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }


        }else if(e.getSource() == this.b3){
            if (cid == null || cid.length() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "id不能为空", "id提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sql = "update myuser set name = '" + cname + "',sex = '" + csex + "',place = '" + cplace +  "' where id = '" + cid + "'";
            try {
                int i = d1.update(sql);
                if (i > 0) {
                    JOptionPane.showMessageDialog(this,
                            "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    String sql1 = "SELECT * FROM myuser";
                    reset(sql1);
                    return;

                } else {
                    JOptionPane.showMessageDialog(this,
                            "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }else if(e.getSource() == this.b4){
            if (cid == null || cid.length() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "id不能为空", "id提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sql = "SELECT * FROM myuser where id = '" + cid + "'";
            reset(sql);
        }else if(e.getSource() == this.b5){
            String sql = "SELECT * FROM myuser";
            reset(sql);
        }
    }
}
