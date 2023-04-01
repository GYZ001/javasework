package org.jinzhi.mis.model.entity;
//用户javabean
public class MyUser {
    private String Id = null;
    private String Name = null;
    private String Password = null;
    private String Memo = null;
    private String RoleId = null;
    private String AddressId = null;


    public MyUser() {
    }

    public MyUser(String Id, String Name, String Password, String Memo, String RoleId, String AddressId) {
        this.Id = Id;
        this.Name = Name;
        this.Password = Password;
        this.Memo = Memo;
        this.RoleId = RoleId;
        this.AddressId = AddressId;
    }

    /**
     * 获取
     * @return Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 设置
     * @param Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 获取
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 设置
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 获取
     * @return Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * 设置
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * 获取
     * @return Memo
     */
    public String getMemo() {
        return Memo;
    }

    /**
     * 设置
     * @param Memo
     */
    public void setMemo(String Memo) {
        this.Memo = Memo;
    }

    /**
     * 获取
     * @return RoleId
     */
    public String getRoleId() {
        return RoleId;
    }

    /**
     * 设置
     * @param RoleId
     */
    public void setRoleId(String RoleId) {
        this.RoleId = RoleId;
    }

    /**
     * 获取
     * @return AddressId
     */
    public String getAddressId() {
        return AddressId;
    }

    /**
     * 设置
     * @param AddressId
     */
    public void setAddressId(String AddressId) {
        this.AddressId = AddressId;
    }

    public String toString() {
        return "MyUser{Id = " + Id + ", Name = " + Name + ", Password = " + Password + ", Memo = " + Memo + ", RoleId = " + RoleId + ", AddressId = " + AddressId + "}";
    }
}
