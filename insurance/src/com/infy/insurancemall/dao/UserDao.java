package com.infy.insurancemall.dao;

import com.infy.insurancemall.entity.UserEntity;
import com.infy.insurancemall.exception.PhoneNumFormatErrorException;

public interface UserDao {
	/**
	 * 登陆
	 * @param phone
	 * @throws Exception
	 */
	public void login(String phone) throws Exception;
	/**
	 * 通过手机号查找用户信息
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public UserEntity findUserByPhone(String phone) throws Exception;
}
