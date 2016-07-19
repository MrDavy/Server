package com.infy.insurancemall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static ThreadLocal<Connection> conns=
			new ThreadLocal<Connection>();

	/***
	 * 封装获取连接对象的方式  
	 * 从ThreadLocal中获取, 若获取到了Conn,则直接返回
	 * 若获取到null, 则创建新的Connection对象存入ThreadLocal
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection()throws Exception{
		Connection conn=conns.get();
		if(conn==null){
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/insurancemall";
			conn=DriverManager.getConnection(url, "root", "");
			conns.set(conn);
		}
		return conn;
	}

	public static void close(){
		Connection conn=conns.get();
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//把ThreadLocal中的Connection 置null
			conns.set(null);
		}
	}


	public static void close(PreparedStatement ps, ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/***
	 * 开启事务
	 * @throws Exception
	 */
	public static void openTransaction()throws Exception{
		Connection conn=getConnection();
		if(conn!=null){
			conn.setAutoCommit(false);
		}
	}

	/**
	 * 提交事务
	 * @throws Exception
	 */
	public static void commit()throws Exception{
		Connection conn=conns.get();
		if(conn!=null){
			conn.commit();
		}
	}

}
