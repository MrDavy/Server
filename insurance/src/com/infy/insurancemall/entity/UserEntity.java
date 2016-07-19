package com.infy.insurancemall.entity;

import java.io.Serializable;

public class UserEntity implements Serializable{
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 用户手机号
	 */
	private String phone;
	
	public UserEntity() {
		super();
	}

	public UserEntity(int id, String phone) {
		super();
		this.id = id;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", phone=" + phone + "]";
	}
}
