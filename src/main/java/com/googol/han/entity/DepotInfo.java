package com.googol.han.entity;

import java.io.Serializable;

public class DepotInfo implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -8041564127815338334L;
	private String depotinfoId ;
	 private String depotDate;
	 private String depotName;
	 private String userId;
	 private String depotId;
	 private String depotInfoExplain;
	 private String goodId;
	 private String goodName;
	 private String goodNumber;
	 private String goodBidPrice;
	 private String goodExplain;
	public String getDepotinfoId() {
		return depotinfoId;
	}
	public void setDepotinfoId(String depotinfoId) {
		this.depotinfoId = depotinfoId;
	}
	public String getDepotDate() {
		return depotDate;
	}
	public void setDepotDate(String depotDate) {
		this.depotDate = depotDate;
	}
	public String getDepotName() {
		return depotName;
	}
	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDepotId() {
		return depotId;
	}
	public void setDepotId(String depotId) {
		this.depotId = depotId;
	}
	public String getDepotInfoExplain() {
		return depotInfoExplain;
	}
	public void setDepotInfoExplain(String depotInfoExplain) {
		this.depotInfoExplain = depotInfoExplain;
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
	public String getGoodBidPrice() {
		return goodBidPrice;
	}
	public void setGoodBidPrice(String goodBidPrice) {
		this.goodBidPrice = goodBidPrice;
	}
	public String getGoodExplain() {
		return goodExplain;
	}
	public void setGoodExplain(String goodExplain) {
		this.goodExplain = goodExplain;
	}
	 
	 
}
