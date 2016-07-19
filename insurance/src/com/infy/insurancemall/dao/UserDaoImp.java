package com.infy.insurancemall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.infy.insurancemall.entity.UserEntity;

public class UserDaoImp implements UserDao {

	@Override
	public UserEntity findUserByPhone(String phone) throws Exception {
		String SQL = "select * from user where phone=?;";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL);
		ps.setString(1, phone);
		ResultSet rs = ps.executeQuery();
		UserEntity entity = null;
		if (rs.next()) {
			entity = new UserEntity(rs.getInt("id"), rs.getString("phone"));
		}
		DBUtil.close(ps, rs);
		DBUtil.close();
		return entity;
	}

	@Override
	public void login(String phone) throws Exception {
		Connection conn = DBUtil.getConnection();
		String SQL = "insert into user values(null,?);";
		PreparedStatement ps = conn.prepareStatement(SQL);
		ps.setString(1, phone);
		ps.executeUpdate();
		DBUtil.close(ps, null);
		DBUtil.close();
	}

}
