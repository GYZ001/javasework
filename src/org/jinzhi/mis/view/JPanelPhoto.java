package org.jinzhi.mis.view;

import javax.swing.*;
import java.awt.*;

public class JPanelPhoto extends JPanel {

    private Image image = null;

    public JPanelPhoto(int n) {
        if (n == 1) {
            image = (Image) new ImageIcon("./img/浅色台灯.jpg").getImage();
        } else if (n == 2){
            image = (Image) new ImageIcon("./img/戈薇.jpg").getImage();
        }
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
