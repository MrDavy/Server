package com.infy.insurancemall.service;

import java.util.ArrayList;

import com.infy.insurancemall.entity.InsureEntity;

public interface InsuranceService {
	/**
	 * �������Ͳ�ѯ������Ϣ
	 * @param type ��������
	 * @return
	 * @throws Exception
	 */
	public ArrayList<InsureEntity> findInsuranceByType(int type) throws Exception;
	
	/**
	 * ���ݱ������ͺͱ���id��ѯ������ϸ��Ϣ
	 * @param type ��������
	 * @param insuranceId ����id
	 * @return ������ϸ��Ϣ
	 * @throws Exception
	 */
	public InsureEntity findInsureDetailEntityById(int insuranceId) throws Exception;

	/**
	 * �����µ�������ѯ
	 * @param dataCount
	 * @return
	 * @throws Exception
	 */
	ArrayList<InsureEntity> favorateInsurance(int dataCount) throws Exception;
}
