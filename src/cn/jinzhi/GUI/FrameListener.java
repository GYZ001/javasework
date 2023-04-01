package cn.jinzhi.GUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameListener extends JFrame implements MouseListener {

    private JPanel jpanel = null;
    private JButton b1 = null;
    private JButton b2 = null;
    private JButton b3 = null;
    private JButton b4 = null;

    private void init() {
        Container con = this.getContentPane();
        con.add(this.jpanel = new JPanel());
        this.jpanel.setLayout(new GridLayout(2, 2));

        this.b1 = new JButton("b1");
        this.b1.addMouseListener(this);
        this.b2 = new JButton("b2");
        this.b3 = new JButton("b3");
        this.b4 = new JButton("b4");

        jpanel.add(this.b1);
        jpanel.add(this.b2);
        jpanel.add(this.b3);
        jpanel.add(this.b4);

        this.setTitle("四种监听方式");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public FrameListener() {
        this.init();
    }

    public static void main(String[] args) {
        FrameListener f1 = new FrameListener();
        f1.setBounds(100, 100, 400, 600);
        f1.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == this.b1) {
            this.b1.setBackground(Color.PINK);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

}
