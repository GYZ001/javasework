package org.jinzhi.mis.control.action;

import org.jinzhi.mis.model.dao.TypeDAOimpl;
import org.jinzhi.mis.model.util.DButil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstitutionInsert implements Action, ActionListener {

    private JPanel panelwork = null;
    private JPanel allpanel = null;
    private JPanel buttonpanel = null;

    private JScrollPane pane = null;

    private JLabel titlelabel = null;
    private JLabel idlabel = null;
    private JLabel namelabel = null;
    private JLabel memolabel = null;


    private JTextField idfiled = null;
    private JTextField namefiled = null;
    private JTextField memofiled = null;

    private JButton sub = null;

    private GridBagConstraints constraints = null;

    private void init() {
        this.allpanel = this.panelwork;
        this.allpanel.setLayout(new GridBagLayout());
        this.allpanel.setBackground(Color.cyan);

        this.constraints = new GridBagConstraints();
        this.titlelabel = new JLabel("Institutional Registration System", JLabel.CENTER);
        this.constraints.gridy = 0;
        this.constraints.gridx = 1;
        this.allpanel.add(this.titlelabel, this.constraints);

        this.idlabel = new JLabel("Institution number:");
        this.constraints.gridy = 1;
        this.constraints.gridx = 0;
        this.allpanel.add(this.idlabel, this.constraints);

        this.namelabel = new JLabel("Institution name:");
        this.constraints.gridy = 2;
        this.constraints.gridx = 0;
        this.allpanel.add(this.namelabel, this.constraints);

        this.memolabel = new JLabel("Institution memo:");
        this.constraints.gridy = 3;
        this.constraints.gridx = 0;
        this.allpanel.add(this.memolabel, this.constraints);

        this.idfiled = new JTextField(18);
        this.constraints.gridy = 1;
        this.constraints.gridx = 1;
        this.allpanel.add(this.idfiled, this.constraints);

        this.namefiled = new JTextField(18);
        this.constraints.gridy = 2;
        this.constraints.gridx = 1;
        this.allpanel.add(this.namefiled, this.constraints);

        this.memofiled = new JTextField(18);
        this.constraints.gridy = 3;
        this.constraints.gridx = 1;
        this.allpanel.add(this.memofiled, this.constraints);


        this.buttonpanel = new JPanel();
        this.buttonpanel.setBackground(Color.cyan);
        this.sub = new JButton("Submit");
        this.sub.addActionListener(this);
        this.buttonpanel.add(sub);
        this.constraints.gridy = 4;
        this.constraints.gridx = 1;
        this.allpanel.add(this.buttonpanel, this.constraints);

    }

    public void reset() {
        this.namefiled.setText("");
        this.idfiled.setText("");
        this.memofiled.setText("");
    }

    @Override
    public void excute(JPanel workpanel) {
        this.panelwork = workpanel;
        this.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String id = idfiled.getText();
        String name = namefiled.getText();
        String memo = memofiled.getText();
        int n = new TypeDAOimpl().update(id, name, memo);
        if (n > 0) {
            JOptionPane.showMessageDialog(panelwork,
                    "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
            reset();
            return;
        }

    }
}
