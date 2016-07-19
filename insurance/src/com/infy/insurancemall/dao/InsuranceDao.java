package com.infy.insurancemall.dao;

import java.util.ArrayList;

import com.infy.insurancemall.entity.InsureEntity;

public interface InsuranceDao {

	/**
	 * �������Ͳ�ѯ������Ϣ
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public ArrayList<InsureEntity> findInsuranceByType(int type)
			throws Exception;
	
	/**
	 * ���ݱ���id��ѯ������ϸ��Ϣ
	 * @param insuranceId
	 * @return
	 * @throws Exception
	 */
	public InsureEntity findInsureDetailEntityById(int insuranceId)
			throws Exception;
	
	/**
	 * ����countֵ��ѯ������Ϣ
	 * @param dataCount
	 * @return
	 * @throws Exception
	 */
	ArrayList<InsureEntity> favorateInsure(int dataCount) throws Exception;

}
