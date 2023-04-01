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

public class InstitutionUpdate implements Action , ActionListener {
    private JPanel panelwork = null;

    private JTabbedPane tabbedPane = null;
    private JPanel panelTable = null;
    private JPanel panelPhoto = null;
    private JPanel panelButton = null;

    private JTable tablebody = null;
    private String[][] data = null;
    private String[] title = null;
    private DefaultTableModel tableModel = null;
    private JScrollPane jScrollPane = null;
    private JButton b1 = null;
    private JButton b2 = null;

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
        this.b1 = new JButton("update");
        this.b1.addActionListener(this);
        this.b2 = new JButton("refresh");
        this.b2.addActionListener(this);
        this.panelButton.add(b1);
        this.panelButton.add(b2);

        this.panelTable.add(this.panelButton,BorderLayout.SOUTH);

    }

    private void setPanelPhoto() {
        this.panelPhoto = new JPanel();

    }

    private void init() {
        this.tabbedPane = new JTabbedPane();
        this.setPanelTable();
        this.setPanelPhoto();
        this.tabbedPane.add("update", this.panelTable);
        this.tabbedPane.add("about", this.panelPhoto);
        this.panelwork.add(this.tabbedPane, BorderLayout.CENTER);

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
            ModifyDialog modifyDialog = new ModifyDialog(orgTypeId, this);
            modifyDialog.setBounds(180, 180, 580, 550);
            modifyDialog.setVisible(true);
        }else if (e.getSource() == this.b2){
            this.refresh();
        }
    }

    public class ModifyDialog extends JDialog implements ActionListener{
        private org.jinzhi.mis.model.entity.Type orgType = null;
        private InstitutionUpdate action = null;

        private JPanel panelBody = null;

        private JLabel orgTypeIdLabel = null;
        private JTextField orgTypeIdField = null;
        private JLabel orgTypeNameLabel = null;
        private JTextField orgTypeNameField = null;
        private JLabel orgTypeMemoLabel = null;
        private JScrollPane orgTypeMemoScroll = null ;
        private JTextArea orgTypeMemoField = null;

        private JPanel buttonJPanle = null;
        private JButton saveOrgType = null;
        private JButton backOrgType = null;

        private void init() {
            this.panelBody = (JPanel)this.getContentPane();
            this.panelBody.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            this.orgTypeIdLabel = new JLabel("机构类别代号:");
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.panelBody.add(this.orgTypeIdLabel, gbc);
            this.orgTypeIdField = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.orgTypeIdField.setEditable(false);
            this.orgTypeIdField.setText(this.orgType.getId());
            this.panelBody.add(this.orgTypeIdField, gbc);

            this.orgTypeNameLabel = new JLabel("机构类别名称");
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.panelBody.add(this.orgTypeNameLabel, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.orgTypeNameField = new JTextField(20);
            this.orgTypeNameField.setText(this.orgType.getName());
            this.panelBody.add(this.orgTypeNameField, gbc);

            this.orgTypeMemoLabel = new JLabel("机构类别备注:");
            gbc.gridx = 0;
            gbc.gridy = 2;
            this.panelBody.add(this.orgTypeMemoLabel, gbc);
            this.orgTypeMemoField = new JTextArea(8, 20);
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.orgTypeMemoField.setText(this.orgType.getMemo());
            this.orgTypeMemoScroll = new JScrollPane(this.orgTypeMemoField);
            this.panelBody.add(this.orgTypeMemoScroll, gbc);

            this.buttonJPanle = new JPanel();
            this.saveOrgType = new JButton("保存");
            this.saveOrgType.addActionListener(this);
            this.backOrgType = new JButton("还原");
            this.backOrgType.addActionListener(this);

            this.buttonJPanle.add(this.saveOrgType);
            this.buttonJPanle.add(this.backOrgType);
            gbc.gridx = 1;
            gbc.gridy = 3;
            this.panelBody.add(this.buttonJPanle,gbc);

            this.setTitle("修改详细页面");
        }

        public ModifyDialog() {
            // TODO Auto-generated constructor stub
        }
        public ModifyDialog(String orgTypeId, InstitutionUpdate action) {
            this.orgType = new TypeDAOimpl().findbyId(orgTypeId);
            this.action = action;

            this.init();
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == this.saveOrgType) {
                String id = this.orgTypeIdField.getText();
                String name = this.orgTypeNameField.getText();
                String memo = this.orgTypeMemoField.getText();

                org.jinzhi.mis.model.entity.Type type = new org.jinzhi.mis.model.entity.Type(id,name,memo);
                if(new TypeDAOimpl().modify(type)) {
                    JOptionPane.showMessageDialog(this, "修改成功！");
                    this.action.refresh();
                } else {
                    JOptionPane.showMessageDialog(this, "修改失败！");
                }
            } else if(e.getSource() == this.backOrgType) {
                this.orgTypeNameField.setText(this.orgType.getName());
                this.orgTypeMemoField.setText(this.orgType.getMemo());
                this.saveOrgType.doClick();
            }
        }
    }
}
