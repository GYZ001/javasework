package cn.jinzhi.JDBC;

import java.sql.*;
//mysql
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String Driver= "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:Mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=gbk";
        String username = "root";
        String password = "123456";

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName(Driver);//加载驱动
            con = DriverManager.getConnection(url,username,password);//访问数据库，建立连接

            statement = con.createStatement();//java获取执行对象
            String sql = "SELECT *FROM test;";
            resultSet = statement.executeQuery(sql);//java执行sql语句，并返回结果

            while(resultSet.next()){
                System.out.print("id="+resultSet.getString("id")+" ");
                System.out.print("name="+resultSet.getString("name")+" ");
                System.out.println("sex="+resultSet.getString("sex")+" ");
            }
        }catch (SQLException e){

            System.out.println("JDBC驱动运行异常");

        }finally {

            try{
                if (resultSet != null){

                    resultSet.close();
                    resultSet = null;
                }
            }catch (SQLException e){
                System.out.println("resultSet释放异常");
            }

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
