package com.googol.han.entity;

import java.io.Serializable;

public class Goods implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 495848544728765354L;
	private String goodId ;
	private String goodName;
	private String goodNumber;
	private String goodType;
	private String goodPrice;
	private String goodState;
	private String goodExplain;
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
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public String getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodState() {
		return goodState;
	}
	public void setGoodState(String goodState) {
		this.goodState = goodState;
	}
	public String getGoodExplain() {
		return goodExplain;
	}
	public void setGoodExplain(String goodExplain) {
		this.goodExplain = goodExplain;
	}
	
	

}
