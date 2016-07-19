package com.infy.insurancemall.entity;

import java.io.Serializable;
import java.util.List;

public class InsureEntity implements Serializable {
	
	/**
	 * id
	 */
	private int id;
	/**
	 * ����
	 */
	private int type;
	/**
	 * ����ͼƬ
	 */
	private String image;
	/**
	 * ��������
	 */
	private String title;
	/**
	 * 	�ʺ������
	 */
	private String suitAges;
	/**
	 * �ʺ���Ⱥ����
	 */
	private String suitDesc;
	/**
	 * ��������
	 */
	private String description;
	/**
	 * ���ռ۸�
	 */
	private double price;
	/**
	 * ��������
	 */
	private String coverageDesc;
	/**
	 * ����ʱ��
	 */
	private List<InsureTimeLtEntity> timeLt;
	/**
	 * ������ϸ
	 */
	private List<ComboEntity> comboEntities;
	
	public InsureEntity() {
		super();
	}

	public InsureEntity(int id, int type, String image, String title,
			String suitAges, String suitDesc, String description, double price,
			String coverageDesc, List<InsureTimeLtEntity> timeLt,
			List<ComboEntity> comboEntities) {
		super();
		this.id = id;
		this.type = type;
		this.image = image;
		this.title = title;
		this.suitAges = suitAges;
		this.suitDesc = suitDesc;
		this.description = description;
		this.price = price;
		this.coverageDesc = coverageDesc;
		this.timeLt = timeLt;
		this.comboEntities = comboEntities;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSuitAges() {
		return suitAges;
	}

	public void setSuitAges(String suitAges) {
		this.suitAges = suitAges;
	}

	public String getSuitDesc() {
		return suitDesc;
	}

	public void setSuitDesc(String suitDesc) {
		this.suitDesc = suitDesc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCoverageDesc() {
		return coverageDesc;
	}

	public void setCoverageDesc(String coverageDesc) {
		this.coverageDesc = coverageDesc;
	}

	public List<InsureTimeLtEntity> getTimeLt() {
		return timeLt;
	}

	public void setTimeLt(List<InsureTimeLtEntity> timeLt) {
		this.timeLt = timeLt;
	}

	public List<ComboEntity> getComboEntities() {
		return comboEntities;
	}

	public void setComboEntities(List<ComboEntity> comboEntities) {
		this.comboEntities = comboEntities;
	}

	@Override
	public String toString() {
		return "InsureEntity [id=" + id + ", type=" + type + ", image=" + image
				+ ", title=" + title + ", suitAges=" + suitAges + ", suitDesc="
				+ suitDesc + ", description=" + description + ", price="
				+ price + ", coverageDesc=" + coverageDesc + ", timeLt="
				+ timeLt + ", comboEntities=" + comboEntities + "]";
	}
}





















