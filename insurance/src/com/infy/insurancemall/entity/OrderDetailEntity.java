package com.infy.insurancemall.entity;

import java.io.Serializable;

public class OrderDetailEntity implements Serializable {
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 交易号
	 */
	private String transactionNum;
	/**
	 * 投保单号
	 */
	private String proposalFormNum;
	/**
	 * 保险大类型(如安全随行)
	 */
	private String typeName;
	/**
	 * 保险明细类型id
	 */
	private int insuranceId;
	/**
	 * 保险主题
	 */
	private String title;
	/**
	 * 保险价格
	 */
	private double price;
	/**
	 * 起保日期
	 */
	private String beginDate;
	/**
	 * 止保日期
	 */
	private String endDate;
	/**
	 * 下单日期
	 */
	private String bookDate;
	/**
	 * 保险时长
	 */
	private int timeLt;
	/**
	 * 时长单位
	 */
	private String timeCompany;
	/**
	 * 投保人
	 */
	private ApplicantEntity applicant;
	/**
	 * 被保人
	 */
	private RecognizeeEntity recognizee;
	/**
	 * 套餐
	 */
	private ComboEntity  comboEntity;

	public OrderDetailEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(String transactionNum) {
		this.transactionNum = transactionNum;
	}

	public String getProposalFormNum() {
		return proposalFormNum;
	}

	public void setProposalFormNum(String proposalFormNum) {
		this.proposalFormNum = proposalFormNum;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
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

	public ApplicantEntity getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}

	public RecognizeeEntity getRecognizee() {
		return recognizee;
	}

	public void setRecognizee(RecognizeeEntity recognizee) {
		this.recognizee = recognizee;
	}

	public ComboEntity getComboEntity() {
		return comboEntity;
	}

	public void setComboEntity(ComboEntity comboEntity) {
		this.comboEntity = comboEntity;
	}

	@Override
	public String toString() {
		return "OrderDetailEntity [id=" + id + ", transactionNum="
				+ transactionNum + ", proposalFormNum=" + proposalFormNum
				+ ", typeName=" + typeName + ", insuranceId=" + insuranceId
				+ ", title=" + title + ", price=" + price + ", beginDate="
				+ beginDate + ", endDate=" + endDate + ", bookDate=" + bookDate
				+ ", timeLt=" + timeLt + ", timeCompany=" + timeCompany
				+ ", applicant=" + applicant + ", recognizee=" + recognizee
				+ ", comboEntity=" + comboEntity + "]";
	}

}
