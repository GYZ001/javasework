package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.Type;

import java.util.List;

public interface TypeDAO {
    public int update(String id,String name,String memo);
    public List<Type> findbylike(Type type);
}
