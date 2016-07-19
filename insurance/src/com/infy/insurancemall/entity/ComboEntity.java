package com.infy.insurancemall.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class ComboEntity implements Serializable {
	/**
	 * id
	 */
	private int id;
	/**
	 * 套餐名字
	 */
	private String name;
	/**
	 * 保险id
	 */
	private int insuranceId;
	/**
	 * 保险类型
	 */
	private int type;

	/**
	 * 保险明细
	 */
	private ArrayList<InsureDetailEntity> detailEntities;
	public ComboEntity() {
		super();
	}

	public ComboEntity(int id, String name, int insuranceId, int type,
			ArrayList<InsureDetailEntity> detailEntities) {
		super();
		this.id = id;
		this.name = name;
		this.insuranceId = insuranceId;
		this.type = type;
		this.detailEntities = detailEntities;
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

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ArrayList<InsureDetailEntity> getDetailEntities() {
		return detailEntities;
	}

	public void setDetailEntities(ArrayList<InsureDetailEntity> detailEntities) {
		this.detailEntities = detailEntities;
	}

	@Override
	public String toString() {
		return "ComboEntity [id=" + id + ", name=" + name + ", insuranceId="
				+ insuranceId + ", type=" + type + ", detailEntities="
				+ detailEntities + "]";
	}

}
