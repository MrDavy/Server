package com.infy.insurancemall.entity;

import java.io.Serializable;
/**
 * Ͷ����
 * @author Davy_Tian
 *
 */
public class ApplicantEntity implements Serializable{

	/**
	 * id
	 */
	private int id;
	/**
	 * Ͷ��������
	 */
	private String name;
	/**
	 * Ͷ����֤������
	 */
	private String certificateType;
	/**
	 * Ͷ����֤������
	 */
	private String certificateNum;
	/**
	 * Ͷ�����ֻ�����
	 */
	private String phone;
	/**
	 * Ͷ��������ʡ��
	 */
	private String province;
	/**
	 * Ͷ�������ڳ���
	 */
	private String city;
	
	public ApplicantEntity() {
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
		return "ApplicantEntity [id=" + id + ", name=" + name
				+ ", certificateType=" + certificateType + ", certificateNum="
				+ certificateNum + ", phone=" + phone + ", province="
				+ province + ", city=" + city + "]";
	}

	
}
