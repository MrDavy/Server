package com.infy.insurancemall.exception;

public class PhoneNumFormatErrorException extends Exception{

	@Override
	public String getMessage() {
		return "手机号码格式错误";
	}
	
}
