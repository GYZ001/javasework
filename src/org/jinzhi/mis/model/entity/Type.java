package org.jinzhi.mis.model.entity;

public class Type {
    private String id = null;
    private String name = null;
    private String memo = null;


    public Type() {
    }

    public Type(String id, String name, String memo) {
        this.id = id;
        this.name = name;
        this.memo = memo;
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

    public String toString() {
        return "Type{id = " + id + ", name = " + name + ", memo = " + memo + "}";
    }
}
