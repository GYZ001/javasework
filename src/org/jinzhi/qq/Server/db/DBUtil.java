package org.jinzhi.qq.Server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private Connection conn = null;
	private Statement sta = null;
	private ResultSet rs = null;
	
	private Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=yqdqq", "sa", "sa");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public DBUtil() {
		this.conn = this.getConn();
	}
	
	public int update(String sql) {
		int n = -1;
		try {
			this.sta = this.conn.createStatement();
			n = this.sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	public ResultSet query(String sql) {
		try {
			this.sta = this.conn.createStatement();
			this.rs = this.sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.rs;
	}
	
	public void close() {
		try {
			if(this.rs != null) {
				this.rs.close();
				this.rs = null;
			}
			if(this.sta != null) {
				this.sta.close();
				this.sta = null;
			}
			if(this.conn != null) {
				this.conn.close();
				this.conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
