package com.googol.han.entity;

import java.io.Serializable;

public class Depot implements Serializable {
	private static final long serialVersionUID = -9004214352834187518L;

	private Integer depotId; 		// �ֿ���
	private String  depotName; 		// �ֿ���
	private String  depotAddress; 	// �ֿ��ַ
	private String  depotUser; 		// �ֿ���ϵ��
	private String  depotUserPhone; 	// �ֿ���ϵ�˵绰
	private String  depotState; 		// �ֿ�״̬
	private String  depotExplain; 	// �ֿⱸע
	public Integer getDepotId() {
		return depotId;
	}
	public void setDepotId(Integer depotId) {
		this.depotId = depotId;
	}
	public String getDepotName() {
		return depotName;
	}
	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}
	public String getDepotAddress() {
		return depotAddress;
	}
	public void setDepotAddress(String depotAddress) {
		this.depotAddress = depotAddress;
	}
	public String getDepotUser() {
		return depotUser;
	}
	public void setDepotUser(String depotUser) {
		this.depotUser = depotUser;
	}
	public String getDepotUserPhone() {
		return depotUserPhone;
	}
	public void setDepotUserPhone(String depotUserPhone) {
		this.depotUserPhone = depotUserPhone;
	}
	public String getDepotState() {
		return depotState;
	}
	public void setDepotState(String depotState) {
		this.depotState = depotState;
	}
	public String getDepotExplain() {
		return depotExplain;
	}
	public void setDepotExplain(String depotExplain) {
		this.depotExplain = depotExplain;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}