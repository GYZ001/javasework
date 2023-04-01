package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.MyUser;

import java.sql.SQLException;
import java.util.List;

//增删改查，模糊查五个公共方法
public interface MyUserDAO {
    public int insertMyUser(MyUser misUser);
    public int deleteMyUser(String id);
    public int updateMyUser(MyUser misUser);
    public List selectMyUser(MyUser misUser);
    public MyUser selectMyUser(String id) throws SQLException;
}
