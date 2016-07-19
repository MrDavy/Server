package com.infy.insurancemall.service;

import java.util.ArrayList;

import com.infy.insurancemall.entity.InsureEntity;

public interface InsuranceService {
	/**
	 * 根据类型查询保险信息
	 * @param type 保险类型
	 * @return
	 * @throws Exception
	 */
	public ArrayList<InsureEntity> findInsuranceByType(int type) throws Exception;
	
	/**
	 * 根据保险类型和保险id查询保险详细信息
	 * @param type 保险类型
	 * @param insuranceId 保险id
	 * @return 保险详细信息
	 * @throws Exception
	 */
	public InsureEntity findInsureDetailEntityById(int insuranceId) throws Exception;

	/**
	 * 根据下单数量查询
	 * @param dataCount
	 * @return
	 * @throws Exception
	 */
	ArrayList<InsureEntity> favorateInsurance(int dataCount) throws Exception;
}
