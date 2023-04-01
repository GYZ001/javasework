package org.jinzhi.mis.model.entity;

public class Function {
    private String id = null;
    private String name = null;
    private String menuclass = null;
    private String memo = null;
    private String menuid = null;

    public Function() {
    }

    public Function(String id, String name, String menuclass, String memo, String menuid) {
        this.id = id;
        this.name = name;
        this.menuclass = menuclass;
        this.memo = memo;
        this.menuid = menuid;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return menuclass
     */
    public String getMenuclass() {
        return menuclass;
    }

    /**
     * 设置
     * @param menuclass
     */
    public void setMenuclass(String menuclass) {
        this.menuclass = menuclass;
    }

    /**
     * 获取
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取
     * @return menuid
     */
    public String getMenuid() {
        return menuid;
    }

    /**
     * 设置
     * @param menuid
     */
    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String toString() {
        return "Function{id = " + id + ", name = " + name + ", menuclass = " + menuclass + ", memo = " + memo + ", menuid = " + menuid + "}";
    }
}
