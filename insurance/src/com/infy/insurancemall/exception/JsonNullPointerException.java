package com.infy.insurancemall.exception;

public class JsonNullPointerException extends Exception {
	@Override
	public String getMessage() {
		return "接收到的订单数据为空";
	}
}
