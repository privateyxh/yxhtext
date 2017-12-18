package com.googol.han.entity;

import java.io.Serializable;

public class Company implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 891575244565973849L;
	private String companyId ;         
	private String companyName ;
	private String companyUser ;
	private String companyPhone;
	private String companyAddress ;
	private String companyState ;
	private String companyExplain ;
	
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyUser() {
		return companyUser;
	}
	public void setCompanyUser(String companyUser) {
		this.companyUser = companyUser;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyState() {
		return companyState;
	}
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}
	public String getCompanyExplain() {
		return companyExplain;
	}
	public void setCompanyExplain(String companyExplain) {
		this.companyExplain = companyExplain;
	}
	
	
	
	
	

}
