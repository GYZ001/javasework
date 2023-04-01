package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.MyMenu;

import java.util.List;

//返回一个菜单集合
public interface MyMenuDAO {
    public List<MyMenu> findBySql(String sql);
}
