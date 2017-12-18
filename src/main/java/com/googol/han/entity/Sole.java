package com.googol.han.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *销售单实体类
 */
public class Sole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4709337849860717640L;
	private String soleId; 		// 销售单ID
	private String soleDate; 	// 时间
	private String companyId; 	// 购买单位单号
	private String userId; 		// 经手人ID
	private String goodId; 		// 商品编号
	private String goodName; 	// 商品名
	private String goodNumber; 	// 商品数量
	private String soleExplain; // 单据备注
	
	
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
