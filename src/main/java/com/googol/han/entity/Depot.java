package com.googol.han.entity;

import java.io.Serializable;

public class Depot implements Serializable {
	private static final long serialVersionUID = -9004214352834187518L;

	private Integer depotId; 		// ²Ö¿â±àºÅ
	private String  depotName; 		// ²Ö¿âÃû
	private String  depotAddress; 	// ²Ö¿âµØÖ·
	private String  depotUser; 		// ²Ö¿âÁªÏµÈË
	private String  depotUserPhone; 	// ²Ö¿âÁªÏµÈËµç»°
	private String  depotState; 		// ²Ö¿â×´Ì¬
	private String  depotExplain; 	// ²Ö¿â±¸×¢
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