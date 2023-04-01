package cn.jinzhi.GUI;

import javax.swing.*;
import java.awt.*;

public class test1 {
    public static void main(String[] args) {
        JFrame desk = new JFrame();//1

        JPanel tablecloth1 = new JPanel();//2
        tablecloth1.setLayout(new GridLayout(3,1));
        JPanel tablecloth2 = new JPanel();
        tablecloth2.setBackground(Color.red);
        JPanel tablecloth3 = new JPanel();
        tablecloth3.setBackground(Color.blue);
        JPanel tablecloth4 = new JPanel();
        tablecloth4.setBackground(Color.GREEN);

        Container table = desk.getContentPane();//3
        table.setLayout(new BorderLayout());
        table.add(tablecloth1,BorderLayout.CENTER);

        tablecloth2.setLayout(new FlowLayout(0));//4
        tablecloth3.setLayout(new BorderLayout());

        GridLayout gridLayout = new GridLayout(2,3);
        gridLayout.setHgap(12);
        gridLayout.setVgap(12);
        tablecloth4.setLayout(gridLayout);

        JButton b1 = new JButton("button 1");
        JButton b2 = new JButton("button 2");
        JButton b3 = new JButton("button 3");
        JButton b4 = new JButton("button 4");
        JButton b5 = new JButton("button 4");

//        tablecloth2.add(b1);
//        tablecloth2.add(b2);
//        tablecloth2.add(b3);
//        tablecloth2.add(b4);
//        tablecloth2.add(b5);

//        tablecloth3.add(b1,BorderLayout.CENTER);
//        tablecloth3.add(b2,BorderLayout.NORTH);
//        tablecloth3.add(b3,BorderLayout.SOUTH);
//        tablecloth3.add(b4,BorderLayout.WEST);
//        tablecloth3.add(b5,BorderLayout.EAST);

        tablecloth4.add(b1);
        tablecloth4.add(b2);
        tablecloth4.add(b3);
        tablecloth4.add(b4);
        tablecloth4.add(b5);

        tablecloth1.add(tablecloth2);
        tablecloth1.add(tablecloth3);
        tablecloth1.add(tablecloth4);

        desk.setTitle("My first java window");
        desk.setSize(500,800);//6
        desk.setLocation(100,150);
        desk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desk.setVisible(true);
    }
}
