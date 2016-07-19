package com.infy.insurancemall.entity;

import java.io.Serializable;
/**
 * 被保人
 * @author Davy_Tian
 *
 */
public class RecognizeeEntity implements Serializable{

	/**
	 * id
	 */
	private int id;
	/**
	 * 被保人名称
	 */
	private String name;
	/**
	 * 被保人证件类型
	 */
	private String certificateType;
	/**
	 * 被保人证件号码
	 */
	private String certificateNum;
	/**
	 * 被保人手机号码
	 */
	private String phone;
	/**
	 * 被保人所在省份
	 */
	private String province;
	/**
	 * 被保人所在城市
	 */
	private String city;
	
	public RecognizeeEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "RecognizeeEntity [id=" + id + ", name=" + name
				+ ", certificateType=" + certificateType + ", certificateNum="
				+ certificateNum + ", phone=" + phone + ", province="
				+ province + ", city=" + city + "]";
	}

}
