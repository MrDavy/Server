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
	 * ��װ��ȡ���Ӷ���ķ�ʽ  
	 * ��ThreadLocal�л�ȡ, ����ȡ����Conn,��ֱ�ӷ���
	 * ����ȡ��null, �򴴽��µ�Connection�������ThreadLocal
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
			//��ThreadLocal�е�Connection ��null
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
	 * ��������
	 * @throws Exception
	 */
	public static void openTransaction()throws Exception{
		Connection conn=getConnection();
		if(conn!=null){
			conn.setAutoCommit(false);
		}
	}

	/**
	 * �ύ����
	 * @throws Exception
	 */
	public static void commit()throws Exception{
		Connection conn=conns.get();
		if(conn!=null){
			conn.commit();
		}
	}

}
