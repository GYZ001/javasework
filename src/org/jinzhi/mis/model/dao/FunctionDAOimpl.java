package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.Function;
import org.jinzhi.mis.model.util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FunctionDAOimpl implements FunctionDAO {
    @Override
    public List<Function> findbymenuid(String menuid) {
        List<Function> list = new ArrayList<>();
        String sql = "select * from misFunction where menuId = '"+ menuid +"'";
        ResultSet rs = new DButil().find(sql);
        try {
            while (rs.next()){
                Function temp = new Function();
                temp.setId(rs.getString(1));
                temp.setName(rs.getString(2));
                temp.setMenuclass(rs.getString(3));
                temp.setMemo(rs.getString(4));

                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Function findbyfunctionid(String functionid) {
        String sql = "select * from misFunction where functionid = '"+ functionid +"'";
        ResultSet rs = new DButil().find(sql);
        Function temp = new Function();
        try {
            while (rs.next()){
                temp.setId(rs.getString(1));
                temp.setName(rs.getString(2));
                temp.setMenuclass(rs.getString(3));
                temp.setMemo(rs.getString(4));
                temp.setMenuid(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public List<Function> findByMenuIdAndRoleId(String menuId, String roleId) {
        List<Function> list = new ArrayList<Function>();
        String sql = "select * from misFunction where menuId = '" + menuId + "' and functionId"
                + " in (select functionId from auth where roleId = '" + roleId + "')";
        DButil dbUtil = new DButil();
        ResultSet rs = dbUtil.find(sql);
        try {
            while(rs.next()) {
                Function tempFunction = new Function();
                tempFunction.setId(rs.getString(1));
                tempFunction.setName(rs.getString(2));
                tempFunction.setMenuclass(rs.getString(3));
                tempFunction.setMemo(rs.getString(4));
                tempFunction.setMenuid(rs.getString(5));
                list.add(tempFunction);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            dbUtil.close();
        }
        return list;
    }
}
