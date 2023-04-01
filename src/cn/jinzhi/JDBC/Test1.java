package cn.jinzhi.JDBC;

import java.sql.*;
//sql sever
public class Test1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String Driver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";//数据库驱动器
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=test";//数据库路径
        String username = "sa";//用户名
        String password = "sa";//密码
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            Class.forName(Driver);//加载驱动
            con = DriverManager.getConnection(url,username,password);//访问数据库，建立连接

            statement = con.createStatement();//java获取执行对象
            String sql = "SELECT *FROM table1;";
            resultSet = statement.executeQuery(sql);//java执行sql语句，并返回结果
            //executeQuery是查询使用的
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
