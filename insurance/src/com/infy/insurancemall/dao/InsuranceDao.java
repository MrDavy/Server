package com.infy.insurancemall.dao;

import java.util.ArrayList;

import com.infy.insurancemall.entity.InsureEntity;

public interface InsuranceDao {

	/**
	 * 根据类型查询保险信息
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public ArrayList<InsureEntity> findInsuranceByType(int type)
			throws Exception;
	
	/**
	 * 根据保险id查询保险详细信息
	 * @param insuranceId
	 * @return
	 * @throws Exception
	 */
	public InsureEntity findInsureDetailEntityById(int insuranceId)
			throws Exception;
	
	/**
	 * 根据count值查询保险信息
	 * @param dataCount
	 * @return
	 * @throws Exception
	 */
	ArrayList<InsureEntity> favorateInsure(int dataCount) throws Exception;

}
