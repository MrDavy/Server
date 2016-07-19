package com.infy.insurancemall.service.imp;

import java.util.ArrayList;

import com.infy.insurancemall.dao.InsuranceDao;
import com.infy.insurancemall.dao.InsuranceDaoImp;
import com.infy.insurancemall.entity.InsureEntity;
import com.infy.insurancemall.service.InsuranceService;

public class InsuranceServiceImp implements InsuranceService {

	@Override
	public ArrayList<InsureEntity> findInsuranceByType(int type)
			throws Exception {
		InsuranceDao dao = new InsuranceDaoImp();
		ArrayList<InsureEntity> entities = dao.findInsuranceByType(type);
		return entities;
	}
	
	@Override
	public ArrayList<InsureEntity> favorateInsurance(int dataCount)
			throws Exception {
		InsuranceDao dao = new InsuranceDaoImp();
		ArrayList<InsureEntity> entities = dao.favorateInsure(dataCount);
		return entities;
	}

	@Override
	public InsureEntity findInsureDetailEntityById(int insuranceId)
			throws Exception {
		InsuranceDao dao = new InsuranceDaoImp();
		InsureEntity entity = dao.findInsureDetailEntityById(insuranceId);
		return entity;
	}

}
