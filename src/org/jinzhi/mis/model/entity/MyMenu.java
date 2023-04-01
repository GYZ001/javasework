package org.jinzhi.mis.model.entity;
//菜单javabean
public class MyMenu {
    private String MenuId = null;
    private String MenuName = null;
    private String MenuMemo = null;
    private String WelcomePage = null;


    public MyMenu() {
    }

    public MyMenu(String MenuId, String MenuName, String MenuMemo, String WelcomePage) {
        this.MenuId = MenuId;
        this.MenuName = MenuName;
        this.MenuMemo = MenuMemo;
        this.WelcomePage = WelcomePage;
    }

    /**
     * 获取
     * @return MenuId
     */
    public String getMenuId() {
        return MenuId;
    }

    /**
     * 设置
     * @param MenuId
     */
    public void setMenuId(String MenuId) {
        this.MenuId = MenuId;
    }

    /**
     * 获取
     * @return MenuName
     */
    public String getMenuName() {
        return MenuName;
    }

    /**
     * 设置
     * @param MenuName
     */
    public void setMenuName(String MenuName) {
        this.MenuName = MenuName;
    }

    /**
     * 获取
     * @return MenuMemo
     */
    public String getMenuMemo() {
        return MenuMemo;
    }

    /**
     * 设置
     * @param MenuMemo
     */
    public void setMenuMemo(String MenuMemo) {
        this.MenuMemo = MenuMemo;
    }

    /**
     * 获取
     * @return WelcomePage
     */
    public String getWelcomePage() {
        return WelcomePage;
    }

    /**
     * 设置
     * @param WelcomePage
     */
    public void setWelcomePage(String WelcomePage) {
        this.WelcomePage = WelcomePage;
    }

    public String toString() {
        return "MyMenu{MenuId = " + MenuId + ", MenuName = " + MenuName + ", MenuMemo = " + MenuMemo + ", WelcomePage = " + WelcomePage + "}";
    }
}
