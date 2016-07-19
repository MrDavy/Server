package com.infy.insurancemall.entity;
/**
 * 客户
 * @author Davy_Tian
 *
 */
public class CustomerEntity {
	
	/**
	 * id
	 */
	private int id;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 用户手机号
	 */
	private String userPhone;
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 客户证件类型
	 */
	private String certificateType;
	/**
	 * 客户证件号码
	 */
	private String certificateNum;
	/**
	 * 客户手机号码
	 */
	private String phone;
	/**
	 * 客户所在省份
	 */
	private String province;
	/**
	 * 客户所在城市
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
