package cn.jinzhi.DBGUI;

import java.sql.*;

public class DBmodel {
    private String Driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:Mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=gbk";
    private String musername = "root";
    private String mpassword = "123456";
    private Connection con = null;
    private Statement statement = null;
    private ResultSet resultSet1 = null;
    private ResultSet resultSet2 = null;

    public DBmodel() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);//加载驱动
        con = DriverManager.getConnection(url, musername, mpassword);//访问数据库，建立连接
        statement = con.createStatement();//java获取执行对象
        System.out.println("数据库连接成功");
    }

    public ResultSet find(String sql) throws SQLException {
        resultSet1 = statement.executeQuery(sql);//java执行sql语句，并返回结果
        return resultSet1;
    }

    public int update(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

}
