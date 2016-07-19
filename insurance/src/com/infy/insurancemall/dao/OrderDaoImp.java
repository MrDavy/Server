package com.infy.insurancemall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.infy.insurancemall.entity.ApplicantEntity;
import com.infy.insurancemall.entity.ComboEntity;
import com.infy.insurancemall.entity.InsureDetailEntity;
import com.infy.insurancemall.entity.InsureEntity;
import com.infy.insurancemall.entity.OrderDetailEntity;
import com.infy.insurancemall.entity.OrderEntity;
import com.infy.insurancemall.entity.RecognizeeEntity;

public class OrderDaoImp implements OrderDao {

	@Override
	public void orderSubmit(OrderEntity orderEntity) {
		Connection conn = null;
		ApplicantEntity applicantEntity = null;
		RecognizeeEntity recognizeeEntity = null;
		try {
			conn = DBUtil.getConnection();
			applicantEntity = orderEntity.getApplicant();
			recognizeeEntity = orderEntity.getRecognizee();
			// �����ֶ��ύ����
			conn.setAutoCommit(false);
			int applicantId = saveApp(applicantEntity, conn);
			int recognizeeId = saveRec(recognizeeEntity, conn);
			saveOrder(orderEntity, applicantId, recognizeeId, conn);
			updateCount(orderEntity, conn);
			// �ύ����
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				// �����쳣�ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close();
		}
	}

	/**
	 * ���±����ύ����
	 * 
	 * @param orderEntity
	 * @param conn
	 */
	private synchronized void updateCount(OrderEntity orderEntity,
			Connection conn) throws Exception {
		int insuranceId = orderEntity.getInsuranceId();
		int count = 0;
		String query = "select count from insurance where id=?";
		String update = "update insurance set count=? where id=?";
		PreparedStatement queryPs = conn.prepareStatement(query);
		PreparedStatement updatePs = conn.prepareStatement(update);
		queryPs.setInt(1, insuranceId);
		ResultSet rs = queryPs.executeQuery();
		while (rs.next()) {
			count = rs.getInt("count");
			updatePs.setInt(1, ++count);
			updatePs.setInt(2, insuranceId);
			updatePs.executeUpdate();
		}
		DBUtil.close(queryPs, rs);
		DBUtil.close(updatePs, null);
	}

	/**
	 * �־û�������Ϣ
	 * 
	 * @param orderEntity
	 * @param conn
	 */
	private void saveOrder(OrderEntity orderEntity, int applicantId,
			int recognizeeId, Connection conn) throws Exception {
		String sql = "insert into orders values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, orderEntity.getUserPhone());
		ps.setString(2, orderEntity.getTransactionNum());
		ps.setString(3, orderEntity.getProposalFormNum());
		ps.setInt(4, applicantId);
		ps.setInt(5, recognizeeId);
		ps.setInt(6, orderEntity.getInsuranceId());
		ps.setDouble(7, orderEntity.getPrice());
		ps.setString(8, orderEntity.getBeginDate());
		ps.setString(9, orderEntity.getEndDate());
		ps.setString(10, orderEntity.getBookDate());
		ps.setInt(11, orderEntity.getTimeLt());
		ps.setString(12, orderEntity.getTimeCompany());
		ps.setInt(13, orderEntity.getComboId());
		ps.setString(14, "��֧��");
		ps.executeUpdate();
		DBUtil.close(ps, null);
	}

	/**
	 * �־û���������Ϣ
	 * 
	 * @param recognizeeEntity
	 * @param conn
	 * @return ���ز���ı�������Ϣ��id
	 * @throws Exception
	 */
	private int saveRec(RecognizeeEntity recognizeeEntity, Connection conn)
			throws Exception {
		int id = -1;
		/** ����֮ǰ�ȿ����Ƿ��Ѿ��д��ˣ�֤��Ψһ */
		String certificateType = recognizeeEntity.getCertificateType();
		String certificateNum = recognizeeEntity.getCertificateNum();
		String verSql = "select id from recognizee where certificateType=? and certificateNum=?";
		PreparedStatement verPs = conn.prepareStatement(verSql);
		verPs.setString(1, certificateType);
		verPs.setString(2, certificateNum);
		ResultSet verRs = verPs.executeQuery();
		while (verRs.next()) {
			id = verRs.getInt("id");
		}
		DBUtil.close(verPs, verRs);
		// ���id������Ĭ��ֵ�����ʾ���ݿ��д��ڴ��ˣ�ֱ�ӷ��ز������id
		// ����ִ�в������
		if (id != -1) {
			return id;
		}
		String sql = "insert into recognizee values(null,?,?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, recognizeeEntity.getName());
		ps.setString(2, recognizeeEntity.getCertificateType());
		ps.setString(3, recognizeeEntity.getCertificateNum());
		ps.setString(4, recognizeeEntity.getPhone());
		ps.setString(5, recognizeeEntity.getProvince());
		ps.setString(6, recognizeeEntity.getCity());
		ps.executeUpdate();
		Statement stt = conn.createStatement();
		ResultSet rs = stt.executeQuery("select LAST_INSERT_ID();");

		if (rs.next()) {
			id = rs.getInt("LAST_INSERT_ID()");
		}
		DBUtil.close(ps, rs);
		if (stt != null) {
			stt.close();
		}
		return id;
	}

	/**
	 * �־û�Ͷ������Ϣ
	 * 
	 * @param applicantEntity
	 * @param conn
	 * @return ���ز����Ͷ������Ϣ��id
	 * @throws Exception
	 */
	private int saveApp(ApplicantEntity applicantEntity, Connection conn)
			throws Exception {
		int id = -1;
		/** ����֮ǰ�ȿ����Ƿ��Ѿ��д��ˣ�֤��Ψһ */
		String certificateType = applicantEntity.getCertificateType();
		String certificateNum = applicantEntity.getCertificateNum();
		String verSql = "select id from applicant where certificateType=? and certificateNum=?";
		PreparedStatement verPs = conn.prepareStatement(verSql);
		verPs.setString(1, certificateType);
		verPs.setString(2, certificateNum);
		ResultSet verRs = verPs.executeQuery();
		while (verRs.next()) {
			id = verRs.getInt("id");
		}
		DBUtil.close(verPs, verRs);
		if (id != -1) {
			return id;
		}

		String sql = "insert into  applicant values(null,?,?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, applicantEntity.getName());
		ps.setString(2, applicantEntity.getCertificateType());
		ps.setString(3, applicantEntity.getCertificateNum());
		ps.setString(4, applicantEntity.getPhone());
		ps.setString(5, applicantEntity.getProvince());
		ps.setString(6, applicantEntity.getCity());
		ps.executeUpdate();
		Statement stt = conn.createStatement();
		ResultSet rs = stt.executeQuery("select LAST_INSERT_ID();");
		if (rs.next()) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int a = rsmd.getColumnCount();
			System.out.println(a);
			System.out.println(rsmd.getColumnName(1));
			id = rs.getInt("LAST_INSERT_ID()");
		}
		System.out.println("appId=" + id);
		DBUtil.close(ps, rs);
		if (stt != null) {
			stt.close();
		}
		return id;
	}

	@Override
	public ArrayList<OrderDetailEntity> queryOrders(String phone,
			String payState) throws Exception {
		ArrayList<OrderDetailEntity> orderEntities = new ArrayList<OrderDetailEntity>();
		OrderDetailEntity orderEntity = null;
		String sql = "select id,insuranceId,transactionNum,recognizeeId,price,beginDate,"
				+ "endDate from orders where userPhone=? and payState=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, phone);
		ps.setString(2, payState);
		ResultSet rs01 = ps.executeQuery();
		while (rs01.next()) {
			orderEntity = new OrderDetailEntity();
			int recognizeeId = rs01.getInt("recognizeeId");
			int insuranceId = rs01.getInt("insuranceId");

			orderEntity.setId(rs01.getInt("id"));
			orderEntity.setTransactionNum(rs01.getString("transactionNum"));
			orderEntity.setPrice(rs01.getDouble("price"));
			orderEntity.setBeginDate(rs01.getString("beginDate"));
			orderEntity.setEndDate(rs01.getString("endDate"));
			orderEntity.setTitle(getTitle(insuranceId, conn));
			orderEntity.setTypeName(getTypeName(insuranceId, conn));
			RecognizeeEntity recognizeeEntity = queryRecognizeeById(
					recognizeeId, conn);
			orderEntity.setRecognizee(recognizeeEntity);
			orderEntities.add(orderEntity);
		}
		DBUtil.close(ps, rs01);
		DBUtil.close();
		System.out.println("��ѯ�����" + orderEntities.toString());
		return orderEntities;
	}

	@Override
	public OrderDetailEntity queryOrderDetailById(int orderId) throws Exception {
		OrderDetailEntity orderEntity = new OrderDetailEntity();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from orders where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, orderId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int insuranceId = rs.getInt("insuranceId");
			int applicantId = rs.getInt("applicantId");
			int recognizeeId = rs.getInt("recognizeeId");
			int comboId = rs.getInt("comboId");

			orderEntity.setId(orderId);
			orderEntity.setProposalFormNum(rs.getString("proposalFormNum"));
			orderEntity.setPrice(rs.getDouble("price"));
			orderEntity.setBeginDate(rs.getString("beginDate"));
			orderEntity.setEndDate(rs.getString("endDate"));
			orderEntity.setBookDate(rs.getString("bookDate"));
			orderEntity.setTitle(getTitle(insuranceId, conn));
			orderEntity.setComboEntity(queryComboById(comboId, conn));
			orderEntity.setApplicant(queryApplicnatById(applicantId, conn));
			orderEntity.setRecognizee(queryRecognizeeById(recognizeeId, conn));
		}
		DBUtil.close(ps, rs);
		DBUtil.close();
		return orderEntity;
	}

	/**
	 * ����id��ȡ��������
	 * 
	 * @param insuranceId
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private String getTitle(int insuranceId, Connection conn) throws Exception {
		String title = "";
		String sql = "select title from insurance where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, insuranceId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			title = rs.getString("title");
		}
		DBUtil.close(ps, rs);
		return title;
	}

	/**
	 * ���ݱ���id��ȡ������������
	 * 
	 * @param insuranceId
	 * @return
	 */
	private String getTypeName(int insuranceId, Connection conn)
			throws Exception {
		String typeName = "";
		int type = -1;
		String sql = "select type from insurance where id=?";
		String typeSql = "select typeName from mimetype where type=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		PreparedStatement typePs = null;
		ResultSet rs01 = null;
		ps.setInt(1, insuranceId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			type = rs.getInt("type");
			if (type != -1) {
				typePs = conn.prepareStatement(typeSql);
				typePs.setInt(1, type);
				rs01 = typePs.executeQuery();
				if (rs01.next()) {
					typeName = rs01.getString("typeName");
				}
				DBUtil.close(typePs, rs01);
			}
		}
		DBUtil.close(ps, rs);
		return typeName;
	}

	/**
	 * ����id��ѯ��������Ϣ
	 * 
	 * @param recognizeeId
	 *            ������id
	 * @return ������ʵ��
	 * @throws Exception
	 */
	public RecognizeeEntity queryRecognizeeById(int recognizeeId,
			Connection conn) throws Exception {
		String sql = "select * from recognizee where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, recognizeeId);
		ResultSet rs = ps.executeQuery();
		RecognizeeEntity entity = new RecognizeeEntity();
		if (rs.next()) {
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			entity.setPhone(rs.getString("phone"));
			entity.setCity(rs.getString("city"));
			entity.setProvince(rs.getString("province"));
			entity.setCertificateType(rs.getString("certificateType"));
			entity.setCertificateNum(rs.getString("certificateNum"));
		}
		DBUtil.close(ps, rs);
		return entity;
	}

	/**
	 * ����id��ѯ�ײ���Ϣ
	 * 
	 * @param comboId
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private ComboEntity queryComboById(int comboId, Connection conn)
			throws Exception {
		ComboEntity comboEntity = new ComboEntity();
		ArrayList<InsureDetailEntity> detailEntities = null;
		String sql = "select * from combo where id=?";
		String detailSql = "select * from detail where comboId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		PreparedStatement ps01 = null;
		ResultSet rs01 = null;
		ps.setInt(1, comboId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			comboEntity.setId(comboId);
			comboEntity.setName(rs.getString("name"));
			ps01 = conn.prepareStatement(detailSql);
			ps01.setInt(1, comboId);
			rs01 = ps01.executeQuery();
			detailEntities = new ArrayList<InsureDetailEntity>();
			InsureDetailEntity detailEntity = null;
			while (rs01.next()) {
				detailEntity = new InsureDetailEntity();
				detailEntity.setComboId(comboId);
				detailEntity.setId(rs01.getInt("id"));
				detailEntity.setTitle(rs01.getString("title"));
				detailEntity.setCoverage(rs01.getDouble("coverage"));
				detailEntity.setCoverageCompany(rs01
						.getString("coverageCompany"));
				detailEntity.setDescription(rs01.getString("description"));
				detailEntities.add(detailEntity);
			}
			DBUtil.close(ps01, rs01);
			comboEntity.setDetailEntities(detailEntities);
		}
		DBUtil.close(ps, rs);
		return comboEntity;
	}

	/**
	 * ����id��ѯͶ������Ϣ
	 * 
	 * @param applicantId
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private ApplicantEntity queryApplicnatById(int applicantId, Connection conn)
			throws Exception {
		ApplicantEntity applicantEntity = new ApplicantEntity();
		String sql = "select * from applicant where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, applicantId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			applicantEntity.setId(rs.getInt("id"));
			applicantEntity.setName(rs.getString("name"));
			applicantEntity.setPhone(rs.getString("phone"));
			applicantEntity.setCity(rs.getString("city"));
			applicantEntity.setProvince(rs.getString("province"));
			applicantEntity.setCertificateType(rs.getString("certificateType"));
			applicantEntity.setCertificateNum(rs.getString("certificateNum"));
		}
		DBUtil.close(ps, rs);
		return applicantEntity;
	}

}
