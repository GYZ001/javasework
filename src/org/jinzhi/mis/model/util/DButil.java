package org.jinzhi.mis.model.util;

import java.sql.*;

//数据库驱动连接方法
//构造函数
//修改方法和查询方法
//关闭方法
public class DButil {
    private Connection conn = null;
    private Statement sta = null;
    private ResultSet rs = null;

    String Driver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=jinzhi";
    String username = "sa";
    String password = "sa";

    private Connection ToDB(){
        Connection conn = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public DButil(){
        this.conn = ToDB();
    }

    public int update(String sql){
        int n = -1;

        try {
            this.sta = this.conn.createStatement();
            n = this.sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public ResultSet find(String sql){
        try {
            this.sta = this.conn.createStatement();
            this.rs = this.sta.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.rs;
    }

    public void close(){
        if(this.rs != null){
            try {
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.rs = null;
            }
        }
        if(this.sta != null){
            try {
                this.sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.sta = null;
            }
        }
        if(this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.conn = null;
            }
        }
    }
}
