package com.googol.han.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *���۵�ʵ����
 */
public class Sole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4709337849860717640L;
	private String soleId; 		// ���۵�ID
	private String soleDate; 	// ʱ��
	private String companyId; 	// ����λ����
	private String userId; 		// ������ID
	private String goodId; 		// ��Ʒ���
	private String goodName; 	// ��Ʒ��
	private String goodNumber; 	// ��Ʒ����
	private String soleExplain; // ���ݱ�ע
	
	
	public String getSoleId() {
		return soleId;
	}
	public void setSoleId(String soleId) {
		this.soleId = soleId;
	}
	public String getSoleDate() {
		return soleDate;
	}
	public void setSoleDate(String soleDate) {
		this.soleDate = soleDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getGoodNumber() {
		return goodNumber;
	}
	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}
	public String getSoleExplain() {
		return soleExplain;
	}
	public void setSoleExplain(String soleExplain) {
		this.soleExplain = soleExplain;
	}

	
	
	
}
