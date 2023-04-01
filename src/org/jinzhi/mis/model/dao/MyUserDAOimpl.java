package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.MyUser;
import org.jinzhi.mis.model.util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyUserDAOimpl implements MyUserDAO {

    private DButil dbu = null;

    @Override
    public int insertMyUser(MyUser misUser) {
        String sql = "insert into misUser (userId,userName,userPwd,userMemo,roleId)" +
                " values ('" + misUser.getId() + "','" + misUser.getName() + "','" + misUser.getPassword() + "','" + misUser.getMemo() + "','" + misUser.getRoleId() + "')";
        System.out.println(sql);
        this.dbu = new DButil();
        int n = dbu.update(sql);
        return n;
    }

    @Override
    public int deleteMyUser(String id) {
        String sql = "delete from misUser where userId = '" + id + "'";
        this.dbu = new DButil();
        int n = dbu.update(sql);
        return n;
    }

    @Override
    public int updateMyUser(MyUser misUser) {
        String sql = "update misuser set userName = '" + misUser.getName() + "',userPwd = '" + misUser.getPassword() + "'," +
                "userMemo = '" + misUser.getMemo() + "',roleId = '" + misUser.getRoleId() + "' where userid = '" + misUser.getId() + "'";
        this.dbu = new DButil();
        int n = dbu.update(sql);
        return n;
    }

    @Override
    public List selectMyUser(MyUser misUser) {
        if (misUser == null) {
            System.out.println("用户名不能为空！");
            return null;
        }
        ArrayList<MyUser> list = null;
        StringBuffer sqlb = new StringBuffer("SELECT * FROM misuser WHERE 1=1 ");
        if (misUser.getId() != null) {
            sqlb.append("and userId like %'" + misUser.getId() + "'% ");
        }
        if (misUser.getName() != null) {
            sqlb.append("and userName like %'" + misUser.getName() + "'% ");
        }
        if (misUser.getPassword() != null) {
            sqlb.append("and userPwd like %'" + misUser.getPassword() + "'% ");
        }
        if (misUser.getAddressId() != null) {
            sqlb.append("and addressId like %'" + misUser.getAddressId() + "'% ");
        }
        if (misUser.getRoleId() != null) {
            sqlb.append("and roleId like %'" + misUser.getRoleId() + "'% ");
        }
        if (misUser.getMemo() != null) {
            sqlb.append("and userMemo like %'" + misUser.getMemo() + "'% ");
        }
        String sql = sqlb.toString();
        this.dbu = new DButil();
        try (ResultSet rs = dbu.find(sql)) {
            list = new ArrayList<MyUser>();
            while (rs.next()) {
                MyUser myUser = new MyUser();
                myUser.setId(rs.getString(1));
                myUser.setName(rs.getString(2));
                myUser.setPassword(rs.getString(3));
                myUser.setMemo(rs.getString(4));
                myUser.setRoleId(rs.getString(5));
                myUser.setAddressId(rs.getString(6));
                list.add(myUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbu.close();
        }
        return list;
    }

    @Override
    public MyUser selectMyUser(String id) {
        MyUser myUser = null;
        String sql = "select * from misuser where userId = '" + id + "'";
        this.dbu = new DButil();
        try (ResultSet rs = dbu.find(sql)) {
            while (rs.next()) {
                myUser = new MyUser();
                myUser.setId(rs.getString(1));
                myUser.setName(rs.getString(2));
                myUser.setPassword(rs.getString(3));
                myUser.setMemo(rs.getString(4));
                myUser.setRoleId(rs.getString(5));
                myUser.setAddressId(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbu.close();
        }
        return myUser;
    }
}
