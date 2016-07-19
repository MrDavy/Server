package com.infy.insurancemall.service;

import com.infy.insurancemall.exception.PhoneNumFormatErrorException;

public interface LoginService {
	/**
	 * 登陆 
	 * @param phone 手机号
	 * @throws PhoneNumFormatErrorException  手机号格式错误
	 * @throws Exception 
	 */
	public void login(String phone) throws PhoneNumFormatErrorException, Exception;
}
