package com.infy.insurancemall.service;

import com.infy.insurancemall.exception.PhoneNumFormatErrorException;

public interface LoginService {
	/**
	 * ��½ 
	 * @param phone �ֻ���
	 * @throws PhoneNumFormatErrorException  �ֻ��Ÿ�ʽ����
	 * @throws Exception 
	 */
	public void login(String phone) throws PhoneNumFormatErrorException, Exception;
}
