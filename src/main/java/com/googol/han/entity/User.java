package com.googol.han.entity;

import java.io.Serializable;

/**
 * @author 员工表的实体类
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 7495724967755712948L;
	
	private String userId;
	private String userName;
	private String userBrither;
	private String userPhone;
	private String userAddress;
	private String userState;
	private String userExplain;
	private String userPassword;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBrither() {
		return userBrither;
	}
	public void setUserBrither(String userBrither) {
		this.userBrither = userBrither;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getUserExplain() {
		return userExplain;
	}
	public void setUserExplain(String userExplain) {
		this.userExplain = userExplain;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
