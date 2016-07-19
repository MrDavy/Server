package com.infy.insurancemall.entity;
import java.io.Serializable;

public class OrderEntity implements Serializable {
	/**
	 * 用户手机号
	 */
	private String userPhone;
	/**
	 * 交易号
	 */
	private String transactionNum;
	/**
	 * 投保单号
	 */
	private String proposalFormNum;
	/**
	 * 保险明细类型id
	 */
	private int insuranceId;
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
	 * 套餐id
	 */
	private int  comboId;
	
	public OrderEntity() {
		super();
	}

	public OrderEntity(String userPhone,String transactionNum,String proposalFormNum,int insuranceId,double price,
			String beginDate,String endDate,String bookDate,int timeLt,String timeCompany,ApplicantEntity applicant,
			RecognizeeEntity recognizee,int  comboId){
		this.userPhone=userPhone;
		this.transactionNum=transactionNum;
		this.proposalFormNum=proposalFormNum;
		this.insuranceId=insuranceId;
		this.price=price;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.bookDate=bookDate;
		this.timeLt=timeLt;
		this.timeCompany=timeCompany;
		this.applicant=applicant;
		this.recognizee=recognizee;
		this.comboId=comboId;
		
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
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

	public int getComboId() {
		return comboId;
	}

	public void setComboId(int comboId) {
		this.comboId = comboId;
	}


	@Override
	public String toString() {
		return "OrderEntity [userPhone="
				+ userPhone + ", transactionNum=" + transactionNum
				+ ", proposalFormNum=" + proposalFormNum + ",insuranceId=" 
				+ insuranceId + ",price="+ price + ", beginDate="
				+ beginDate + ", endDate=" + endDate + ", bookDate=" + bookDate
				+ ", timeLt=" + timeLt + ", timeCompany=" + timeCompany
				+ ", applicant=" + applicant + ", recognizee=" + recognizee
				+ ", comboId=" + comboId + "]";
	}

}
