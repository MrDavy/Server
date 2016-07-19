package com.infy.insurancemall.entity;
/**
 * �ͻ�
 * @author Davy_Tian
 *
 */
public class CustomerEntity {
	
	/**
	 * id
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int userId;
	/**
	 * �û��ֻ���
	 */
	private String userPhone;
	/**
	 * �ͻ�����
	 */
	private String name;
	/**
	 * �ͻ�֤������
	 */
	private String certificateType;
	/**
	 * �ͻ�֤������
	 */
	private String certificateNum;
	/**
	 * �ͻ��ֻ�����
	 */
	private String phone;
	/**
	 * �ͻ�����ʡ��
	 */
	private String province;
	/**
	 * �ͻ����ڳ���
	 */
	private String city;
	public CustomerEntity() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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
		return "CustomerEntity [id=" + id + ", userId=" + userId
				+ ", userPhone=" + userPhone + ", name=" + name
				+ ", certificateType=" + certificateType + ", certificateNum="
				+ certificateNum + ", phone=" + phone + ", province="
				+ province + ", city=" + city + "]";
	}
	
}
