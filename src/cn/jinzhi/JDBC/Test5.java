package cn.jinzhi.JDBC;

import java.sql.*;

//orecal
public class Test5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String Driver= "oracle.jdbc.driver.OracleDriver";//数据库驱动器
        String url = "jdbc:oracle:thin:@//localhost:1521/jinzhi";//数据库路径
        String username = "root";//用户名
        String password = "Gyz132518";//密码

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName(Driver);//加载驱动
            con = DriverManager.getConnection(url,username,password);//访问数据库，建立连接

            statement = con.createStatement();//java获取执行对象
            //test为表名，修改、添加和删除只需要修改sql
            //String sql = "insert into test(id,name,sex) values('004','大撒','男')";
            //String sql2 = "delete from test where id = '004'";
            String sql3 = "UPDATE test SET name = '张三' WHERE id = '001'";
            int i = statement.executeUpdate(sql3);//执行update代码
            //executeUpdate是‘增删改’使用的

            if (i > 0){
                System.out.println("Success！");

            }else {
                System.out.println("Defeat~");
            }
        }catch (SQLException e){

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
