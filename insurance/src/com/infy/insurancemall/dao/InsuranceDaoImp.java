package com.infy.insurancemall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.insurancemall.entity.ComboEntity;
import com.infy.insurancemall.entity.InsureDetailEntity;
import com.infy.insurancemall.entity.InsureEntity;
import com.infy.insurancemall.entity.InsureTimeLtEntity;
import com.sun.xml.internal.stream.Entity;

public class InsuranceDaoImp implements InsuranceDao {
	
	/**
	 * 通过类型查询所有保险数据
	 */
	@Override
	public ArrayList<InsureEntity> findInsuranceByType(int type) {
		ArrayList<InsureEntity> entities = new ArrayList<InsureEntity>();
		String sql = "select * from insurance where type=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, type);
			rs = ps.executeQuery();
			InsureEntity entity = null;
			while (rs.next()) {
				entity = new InsureEntity();
				entity.setId(rs.getInt("id"));
				entity.setType(rs.getInt("type"));
				entity.setTitle(rs.getString("title"));
				entity.setPrice(rs.getDouble("price"));
				entity.setSuitDesc(rs.getString("suitDesc"));
				entity.setCoverageDesc(rs.getString("coverageDesc"));
				entity.setDescription(rs.getString("description"));
				entity.setImage(rs.getString("image"));
				entities.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
			DBUtil.close(ps, rs);
		}
		return entities;
	}
	
	
	/**
	 * 据count值查询保险信息
	 */
	@Override
	public ArrayList<InsureEntity> favorateInsure(int dataCount) {
		ArrayList<InsureEntity> entities = new ArrayList<InsureEntity>();
		String sql = "select * from insurance where count>0 order by count desc limit ?;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dataCount);
			rs = ps.executeQuery();
			InsureEntity entity = null;
			while (rs.next()) {
				entity = new InsureEntity();
				entity.setId(rs.getInt("id"));
				entity.setType(rs.getInt("type"));
				entity.setTitle(rs.getString("title"));
				entity.setPrice(rs.getDouble("price"));
				entity.setSuitDesc(rs.getString("suitDesc"));
				entity.setCoverageDesc(rs.getString("coverageDesc"));
				entity.setDescription(rs.getString("description"));
				entity.setImage(rs.getString("image"));
				entities.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
			DBUtil.close(ps, rs);
		}
		return entities;
	}
	
	/**
	 * 根据id查询保险详情
	 */
	public InsureEntity findInsureDetailEntityById(int id) throws Exception {
		Connection conn = DBUtil.getConnection();
		InsureEntity entity = queryInsurance(id, conn);
		ArrayList<InsureTimeLtEntity> timeLtEntities = queryTime(id, conn);
//		System.out.println(timeLtEntities.toString());
		entity.setTimeLt(timeLtEntities);
		ArrayList<ComboEntity> comboEntities = queryCombo(id, conn);
//		System.out.println(comboEntities.toString());
		entity.setComboEntities(comboEntities);
//		System.out.println(entity.toString());
		DBUtil.close();
		return entity;
	}
	
	private InsureEntity queryInsurance(int id, Connection conn)
			throws SQLException {
		InsureEntity entity = new InsureEntity();
		PreparedStatement ps;
		ResultSet rs01;
		String sql = "select * from insurance where Id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs01 = ps.executeQuery();
		while (rs01.next()) {
			entity.setId(rs01.getInt("id"));
			entity.setType(rs01.getInt("type"));
			entity.setTitle(rs01.getString("title"));
			entity.setPrice(rs01.getDouble("price"));
			entity.setSuitDesc(rs01.getString("suitDesc"));
			entity.setCoverageDesc(rs01.getString("coverageDesc"));
			entity.setDescription(rs01.getString("description"));
			entity.setSuitAges(rs01.getString("suitAges"));
			entity.setImage(rs01.getString("image"));
		}
		DBUtil.close(ps, rs01);
		return entity;
	}
	/**
	 * 根据id查询保险时长
	 * @param id
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<InsureTimeLtEntity> queryTime(int id, Connection conn)
			throws SQLException {
		PreparedStatement ps;
		ResultSet rs01;
		String timeSql = "select * from time where insuranceId=?";
		ps = conn.prepareStatement(timeSql);
		ps.setInt(1, id);
		rs01 = ps.executeQuery();
		ArrayList<InsureTimeLtEntity> timeLtEntities = new ArrayList<InsureTimeLtEntity>();
		InsureTimeLtEntity timeLtEntity = null;
		while (rs01.next()) {
			timeLtEntity = new InsureTimeLtEntity();
			timeLtEntity.setId(rs01.getInt("id"));
			timeLtEntity.setInsuranceId(rs01.getInt("insuranceId"));
			timeLtEntity.setType(rs01.getInt("type"));
			timeLtEntity.setTimeLt(rs01.getInt("timeLt"));
			timeLtEntity.setTimeCompany(rs01.getString("timeCompany"));
			timeLtEntities.add(timeLtEntity);
		}
		DBUtil.close(ps, rs01);
		return timeLtEntities;
	}
	/**
	 * 根据id查询保险
	 * @param id
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<ComboEntity> queryCombo(int id, Connection conn)
			throws SQLException {
		PreparedStatement ps;
		ResultSet rs01;
		String comboSql = "select * from combo where insuranceId=?";
		ps = conn.prepareStatement(comboSql);
		ps.setInt(1, id);
		rs01 = ps.executeQuery();
		ArrayList<ComboEntity> comboEntities = new ArrayList<ComboEntity>();
		ComboEntity comboEntity = null;
		ArrayList<InsureDetailEntity> detailEntities = null;
		while (rs01.next()) {
			comboEntity = new ComboEntity();
			int comboId = rs01.getInt("id");
			comboEntity.setId(comboId);
			comboEntity.setInsuranceId(rs01.getInt("insuranceId"));
			comboEntity.setName(rs01.getString("name"));
			comboEntity.setType(rs01.getInt("type"));
			detailEntities = queryDetail(conn, comboId);
			comboEntity.setDetailEntities(detailEntities);
			comboEntities.add(comboEntity);
		}
		DBUtil.close(ps, rs01);
		return comboEntities;
	}

	/**
	 * 根据套餐id查询保险详细信息
	 * @param conn
	 * @param comboId
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<InsureDetailEntity> queryDetail(Connection conn,
			int comboId) throws SQLException {
		String detailSql = "select * from detail where comboId=?";
		ArrayList<InsureDetailEntity> detailEntities;
		InsureDetailEntity detailEntity;
		PreparedStatement ps = conn.prepareStatement(detailSql);
		ps.setInt(1, comboId);
		ResultSet rs = ps.executeQuery();
		detailEntities = new ArrayList<InsureDetailEntity>();
		while (rs.next()) {
			detailEntity = new InsureDetailEntity();
			detailEntity.setId(rs.getInt("id"));
			detailEntity.setType(rs.getInt("type"));
			detailEntity.setInsuranceId(rs.getInt("insuranceId"));
			detailEntity.setComboId(comboId);
			detailEntity.setTitle(rs.getString("title"));
			detailEntity.setDescription(rs.getString("description"));
			detailEntity.setCoverage(rs.getDouble("coverage"));
			detailEntity.setCoverageCompany(rs.getString("coverageCompany"));
			detailEntities.add(detailEntity);
		}
		DBUtil.close(ps, rs);
		return detailEntities;
	}

}
