package com.infy.insurancemall.entity;

import java.io.Serializable;
/**
 * ������ϸʵ��
 * @author Davy_Tian
 *
 */
public class InsureDetailEntity implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * ��������
	 */
	private int type;
	/**
	 * ��������item��id
	 */
	private int insuranceId;
	/**
	 * �����ײ�id
	 */
	private int comboId;
	/**
	 * ������ϸ����
	 */
	private String title;
	/**
	 * ������ϸ����
	 */
	private String description;
	/**
	 * ����
	 */
	private double coverage;
	/**
	 * ���λ
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
