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
//org.jinzhi.mis.control.action.InstitutionSelect
public class InstitutionSearch implements Action, ActionListener {
    private JPanel panelwork = null;

    private JPanel panelsearch = null;
    private JPanel panelTable = null;

    private JLabel labelsearch = null;
    private JTextField fieldId = null;

    private JButton b1 = null;

    private JTable tablebody = null;
    private String[][] data = null;
    private String[] title = null;
    private DefaultTableModel tableModel = null;
    private JScrollPane jScrollPane = null;


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

    private void setPanelTable(Type type) {
        this.panelTable = new JPanel(new BorderLayout());


        this.panelsearch = new JPanel();
        this.labelsearch = new JLabel("Id");
        this.panelsearch.add(labelsearch);
        this.fieldId = new JTextField(16);
        this.panelsearch.add(fieldId);
        this.b1 = new JButton("Select");
        this.b1.addActionListener(this);
        this.panelsearch.add(b1);
        this.panelTable.add(this.panelsearch, BorderLayout.NORTH);

        this.data = this.getData(type);
        this.title = new String[]{"id", "name", "memo"};
        this.tableModel = new DefaultTableModel(this.data, this.title);
        this.tablebody = new JTable(this.tableModel);
        this.jScrollPane = new JScrollPane(this.tablebody);
        this.panelTable.add(this.jScrollPane, BorderLayout.CENTER);


    }


    private void init(Type type) {
        this.panelwork.removeAll();
        this.panelwork.repaint();
        this.setPanelTable(type);
        this.panelwork.add(this.panelTable, BorderLayout.CENTER);
        this.panelwork.updateUI();
    }

    @Override
    public void excute(JPanel workpanel) {
        this.panelwork = workpanel;
        this.panelwork.setLayout(new BorderLayout());
        this.init(new Type());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.b1) {
            String id = this.fieldId.getText();
            Type type = new Type();
            type.setId(id);

            this.panelwork.removeAll();
            init(type);

        }
    }
}
