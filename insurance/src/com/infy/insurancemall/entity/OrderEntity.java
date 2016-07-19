package com.infy.insurancemall.entity;
import java.io.Serializable;

public class OrderEntity implements Serializable {
	/**
	 * �û��ֻ���
	 */
	private String userPhone;
	/**
	 * ���׺�
	 */
	private String transactionNum;
	/**
	 * Ͷ������
	 */
	private String proposalFormNum;
	/**
	 * ������ϸ����id
	 */
	private int insuranceId;
	/**
	 * ���ռ۸�
	 */
	private double price;
	/**
	 * ������
	 */
	private String beginDate;
	/**
	 * ֹ������
	 */
	private String endDate;
	/**
	 * �µ�����
	 */
	private String bookDate;
	/**
	 * ����ʱ��
	 */
	private int timeLt;
	/**
	 * ʱ����λ
	 */
	private String timeCompany;
	/**
	 * Ͷ����
	 */
	private ApplicantEntity applicant;
	/**
	 * ������
	 */
	private RecognizeeEntity recognizee;
	/**
	 * �ײ�id
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
