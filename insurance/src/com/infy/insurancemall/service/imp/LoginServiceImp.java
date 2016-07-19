package com.infy.insurancemall.service.imp;

import com.infy.insurancemall.dao.UserDao;
import com.infy.insurancemall.dao.UserDaoImp;
import com.infy.insurancemall.entity.UserEntity;
import com.infy.insurancemall.exception.PhoneNumFormatErrorException;
import com.infy.insurancemall.service.LoginService;

public class LoginServiceImp implements LoginService{

	@Override
	public void login(String phone) throws Exception{
		String reg="\\d{11}";
		if(!phone.matches(reg)){
			throw new PhoneNumFormatErrorException();
		}
		UserDao dao=new UserDaoImp();
		UserEntity entity=dao.findUserByPhone(phone);
		if(entity==null){
			dao.login(phone);
		}
	}

}
