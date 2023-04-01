package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.Type;
import org.jinzhi.mis.model.util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAOimpl implements TypeDAO {

    public boolean modify(Type orgType) {
        boolean flag = false;
        String id = orgType.getId();
        String name = orgType.getName();
        String memo = orgType.getMemo();
        String sql = "update orgType set orgTypeName = '" + name + "', orgTypeMemo = '" + memo + "' where orgTypeId = '" + id + "'";
        System.out.println(sql);
        DButil dbUtil = new DButil();
        int n = dbUtil.update(sql);
        if(n > 0) {
            flag = true;
        }
        dbUtil.close();
        return flag;
    }

    public boolean deletebyid(String id) {
        boolean flag = false;
        String sql = "delete from orgType where orgTypeId = '"+ id +"'";
        System.out.println(sql);
        DButil dbUtil = new DButil();
        int n = dbUtil.update(sql);
        if(n > 0) {
            flag = true;
        }
        dbUtil.close();
        return flag;
    }

    @Override
    public int update(String id, String name, String memo) {

        int n = 0;
        DButil db = new DButil();
        String sql = "insert into orgType(orgTypeId,orgTypeName,orgTypeMemo) values ('"+id+"','"+ name+"','"+memo+"')";
        n = db.update(sql);
        db.close();
        return n;

    }

    @Override
    public List<Type> findbylike(Type type) {

        List<Type> list = new ArrayList<>();
        String id = type.getId();
        String name = type.getName();
        String memo = type.getMemo();


        String select = "select * from orgType where 1=1";
        String where = "";

        if(id != null && id.length() > 0) {
            where = where + " and orgTypeId like '%" + id + "%'";
        }
        if(name != null && name.length() > 0) {
            where = where + " and orgTypeName like '%" + name + "%'";
        }
        if(memo != null && memo.length() > 0) {
            where = where + " and orgTypeMemo like '%" + memo + "%'";
        }
        String sql = select + where;
        System.out.println(sql);

        DButil db = new DButil();
        ResultSet rs = db.find(sql);

            try {
                while (rs.next()){
                    Type type1 = new Type();
                    type1.setId(rs.getString("orgTypeId"));
                    type1.setName(rs.getString("orgTypeName"));
                    type1.setMemo(rs.getString("orgTypeMemo"));
                    list.add(type1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return list;
    }

    public Type findbyId(String orgTypeId) {
        Type orgType = null;
        String sql = "select * from orgType where orgTypeId = '" + orgTypeId + "'";
        DButil dbUtil = new DButil();
        ResultSet rs = dbUtil.find(sql);
        try {
            while(rs.next()) {
                orgType = new Type();
                orgType.setId(rs.getString(1));
                orgType.setName(rs.getString(2));
                orgType.setMemo(rs.getString(3));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            dbUtil.close();
        }
        return orgType;
    }
}
