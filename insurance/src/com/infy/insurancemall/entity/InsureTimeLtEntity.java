package com.infy.insurancemall.entity;

import java.io.Serializable;
/**
 * 保险时长实体
 * @author Davy_Tian
 *
 */
public class InsureTimeLtEntity implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * 保险类型
	 */
	private int type;
	/**
	 * 保险类型id
	 */
	private int insuranceId;
	/**
	 * 时长
	 */
	private int timeLt;
	/**
	 * 时间单位
	 */
	private String timeCompany;
	public InsureTimeLtEntity() {
		super();
	}
	public InsureTimeLtEntity(int id, int type, int insuranceId, int timeLt,
			String timeCompany) {
		super();
		this.id = id;
		this.type = type;
		this.insuranceId = insuranceId;
		this.timeLt = timeLt;
		this.timeCompany = timeCompany;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public int getTimeLt() {
		return timeLt;
	}
	public void setTimeLt(int timeLt) {
		this.timeLt = timeLt;
	}
	public String getTimeCompany() {
		return timeCompany;
	}
	public void setTimeCompany(String timeCompany) {
		this.timeCompany = timeCompany;
	}
	@Override
	public String toString() {
		return "InsureTimeLtEntity [id=" + id + ", type=" + type
				+ ", insuranceId=" + insuranceId + ", timeLt=" + timeLt
				+ ", timeCompany=" + timeCompany + "]";
	}
}
