package com.infy.insurancemall.entity;

import java.io.Serializable;
/**
 * 保险明细实体
 * @author Davy_Tian
 *
 */
public class InsureDetailEntity implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * 保险类型
	 */
	private int type;
	/**
	 * 保险类型item的id
	 */
	private int insuranceId;
	/**
	 * 保险套餐id
	 */
	private int comboId;
	/**
	 * 保险明细标题
	 */
	private String title;
	/**
	 * 保险明细描述
	 */
	private String description;
	/**
	 * 保额
	 */
	private double coverage;
	/**
	 * 保额单位
	 */
	private String coverageCompany;

	public InsureDetailEntity() {
		super();
	}

	public InsureDetailEntity(int id, int type, String title,
			String description, double coverage, String coverageCompany,
			int insuranceId, int comboId) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.description = description;
		this.coverage = coverage;
		this.coverageCompany = coverageCompany;
		this.insuranceId = insuranceId;
		this.comboId = comboId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	public String getCoverageCompany() {
		return coverageCompany;
	}

	public void setCoverageCompany(String coverageCompany) {
		this.coverageCompany = coverageCompany;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public int getComboId() {
		return comboId;
	}

	public void setComboId(int comboId) {
		this.comboId = comboId;
	}

	@Override
	public String toString() {
		return "InsureDetailEntity [id=" + id + ", type=" + type + ", title="
				+ title + ", description=" + description + ", coverage="
				+ coverage + ", coverageCompany=" + coverageCompany
				+ ", insuranceId=" + insuranceId + ", comboId=" + comboId + "]";
	}
	
}
