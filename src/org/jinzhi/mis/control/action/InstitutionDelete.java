package org.jinzhi.mis.control.action;

import org.jinzhi.mis.model.dao.TypeDAO;
import org.jinzhi.mis.model.dao.TypeDAOimpl;
import org.jinzhi.mis.model.entity.Type;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InstitutionDelete implements Action , ActionListener {
    private JPanel panelwork = null;

    private JPanel panelTable = null;
    private JPanel panelButton = null;

    private JTable tablebody = null;
    private String[][] data = null;
    private String[] title = null;
    private DefaultTableModel tableModel = null;
    private JScrollPane jScrollPane = null;
    private JButton b1 = null;

    private void refresh(){
        this.data = this.getData(new Type());
        this.tableModel = new DefaultTableModel(this.data,this.title);

        this.tablebody.removeAll();
        this.tablebody.repaint();
        this.tablebody.setModel(this.tableModel);
    }

    private String[][] getData(Type type) {
        String[][] data = null;
        TypeDAO typeDAO = new TypeDAOimpl();
        List<Type> list = typeDAO.findbylike(type);

        data = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            Type type1 = list.get(i);
            data[i][0] = type1.getId();
            data[i][1] = type1.getName();
            data[i][2] = type1.getMemo();
        }
        return data;

    }

    private void setPanelTable() {
        this.panelTable = new JPanel(new BorderLayout());

        this.data = this.getData(new Type());
        this.title = new String[]{"id","name","memo"};
        this.tableModel = new DefaultTableModel(this.data,this.title);
        this.tablebody = new JTable(this.tableModel);
        this.jScrollPane = new JScrollPane(this.tablebody);
        this.panelTable.add(this.jScrollPane,BorderLayout.CENTER);

        this.panelButton = new JPanel();
        this.b1 = new JButton("Delete");
        this.b1.addActionListener(this);
        this.panelButton.add(b1);

        this.panelTable.add(this.panelButton,BorderLayout.SOUTH);

    }


    private void init() {
        this.setPanelTable();
        this.panelwork.add(this.panelTable, BorderLayout.CENTER);

    }

    @Override
    public void excute(JPanel workpanel) {
        this.panelwork = workpanel;
        this.panelwork.removeAll();
        this.panelwork.repaint();
        this.panelwork.setLayout(new BorderLayout());
        this.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.b1){
            int n = this.tablebody.getSelectedColumn();
            if (n != 1){
                JOptionPane.showMessageDialog(null,"select one data!");
                return;
            }
            String orgTypeId = this.tableModel.getValueAt(this.tablebody.getSelectedRow(), 0).toString();
            if(new TypeDAOimpl().deletebyid(orgTypeId)) {
                JOptionPane.showMessageDialog(null, "修改成功！");
                this.refresh();
            } else {
                JOptionPane.showMessageDialog(null, "修改失败！");
            }
        }
    }
}
