package org.jinzhi.mis.control.listener;

import org.jinzhi.mis.control.action.Action;
import org.jinzhi.mis.control.action.InstitutionInsert;
import org.jinzhi.mis.model.dao.FunctionDAOimpl;
import org.jinzhi.mis.model.entity.MyUser;
import org.jinzhi.mis.view.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionListener implements ActionListener {

    private JFrame mainfram = null;
    private JPanel panelbody = null;
    private JPanel panelwel = null;
    private JPanel panelwork = null;

    public FunctionListener() {
    }
    public FunctionListener(JFrame mainfram) {
        this.mainfram = mainfram;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.panelbody = (JPanel)this.mainfram.getContentPane();
        this.panelwel  = (JPanel)panelbody.getComponent(2);
        this.panelwork = (JPanel)this.panelwel.getComponent(1);
        this.panelwork.removeAll();


        try {
            String functionid = e.getActionCommand();
            Action action = null;

            String classname = new FunctionDAOimpl().findbyfunctionid(functionid).getMenuclass();
            Class myclass = null;
            myclass = Class.forName(classname);
            action = (Action)myclass.newInstance();
            action.excute(panelwork);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }


        this.panelwork.repaint();
        this.mainfram.setVisible(true);
    }
}
