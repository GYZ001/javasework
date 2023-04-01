package cn.jinzhi.JDBC;

import java.sql.*;
//mysql
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String Driver= "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:Mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=gbk";
        String username = "root";
        String password = "123456";

        Connection con = null;
        Statement statement = null;

        try {
            Class.forName(Driver);//加载驱动
            con = DriverManager.getConnection(url,username,password);//访问数据库，建立连接

            statement = con.createStatement();//java获取执行对象
            //修改、添加和删除只需要修改sql,执行update方法
            String num = "004";
            String sql = "insert into test(password,name,sex) values(num,'大撒','男')";
            //String sql2 = "delete from test where id = '004'";
            //String sql3 = "update test set name = '张三' where id = '001'";
            int i = statement.executeUpdate(sql);

            if (i > 0){
                System.out.println("Success！");

            }else {
                System.out.println("Defeat~");
            }

        } catch (SQLException e){

            System.out.println("JDBC驱动运行异常");

        }finally {

            try{
                if (statement != null){

                    statement.close();
                    statement = null;
                }
            }catch (SQLException e){
                System.out.println("statement释放异常");
            }

            try{
                if (con != null){

                    con.close();
                    con = null;
                }
            }catch (SQLException e){
                System.out.println("con释放异常");
            }

        }
    }
}
