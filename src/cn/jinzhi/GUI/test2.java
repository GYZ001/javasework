package cn.jinzhi.GUI;

import javax.swing.*;
import java.awt.*;

public class test2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        JPanel jp = new JPanel();
        GridBagLayout gl = new GridBagLayout();
        jp.setLayout(new GridBagLayout());
        jp.setBackground(Color.blue);

        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 9;
        gb.gridy = 9;
        gb.gridwidth = 9;
        gb.gridheight = 9;

        gl.setConstraints(jp,gb);
        Container table = jFrame.getContentPane();
        table.setLayout(gl);
        table.add(jp);

        JButton b1 = new JButton("button 1");
        jp.add(b1);
        JButton b2 = new JButton("button 2");
        jp.add(b2);

        jFrame.setTitle("second windows");
        jFrame.setSize(300, 500);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);

    }
}
