package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.MyMenu;
import org.jinzhi.mis.model.util.DButil;
import sun.security.pkcs11.Secmod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyMenuDAOimpl implements MyMenuDAO {
    @Override
    public List<MyMenu> findBySql(String sql) {
        List<MyMenu> list = new ArrayList<>();
        DButil dbu = new DButil();
        MyMenu myMenu = null;
        try {
            ResultSet rs = dbu.find(sql);
            while (rs.next()) {
                myMenu = new MyMenu();
                myMenu.setMenuId(rs.getString(1));
                myMenu.setMenuName(rs.getString(2));
                myMenu.setMenuMemo(rs.getString(3));
                myMenu.setWelcomePage(rs.getString(4));
                list.add(myMenu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbu.close();
        }
        return list;
    }
}
