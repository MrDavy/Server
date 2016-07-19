package com.infy.insurancemall.dao;

import com.infy.insurancemall.entity.UserEntity;
import com.infy.insurancemall.exception.PhoneNumFormatErrorException;

public interface UserDao {
	/**
	 * ��½
	 * @param phone
	 * @throws Exception
	 */
	public void login(String phone) throws Exception;
	/**
	 * ͨ���ֻ��Ų����û���Ϣ
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public UserEntity findUserByPhone(String phone) throws Exception;
}
