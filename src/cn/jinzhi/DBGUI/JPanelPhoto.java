package cn.jinzhi.DBGUI;

import javax.swing.*;
import java.awt.*;

public class JPanelPhoto extends JPanel {


    private Image image = (Image) new ImageIcon("./img/戈薇.jpg").getImage();

    public JPanelPhoto() {
    }
    public JPanelPhoto(GridBagLayout gridBagLayout) {
    }


    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
