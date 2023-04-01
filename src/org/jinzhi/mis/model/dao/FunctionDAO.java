package org.jinzhi.mis.model.dao;

import org.jinzhi.mis.model.entity.Function;

import java.util.List;

public interface FunctionDAO {
    public List<Function> findbymenuid(String menuid);
    public Function findbyfunctionid(String functionid);
    public List<Function> findByMenuIdAndRoleId(String menuId, String roleId);
}
