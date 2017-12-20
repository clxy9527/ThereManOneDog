package com.oa.pojo;

import java.util.Date;
import java.util.List;

public class Employee {
	private String eId;
	private String eName;
	private String ePassword;
	private String ePhone;
	private String eCard;
	private int pId;
	private int dId;
	private String eIndate;
	private String eOutdate;
	private int eState;
	private String eAddress;
	private int readState;
	private Department department;
	private Position position;
	private String eSex;

	
	public String geteSex() {
		return eSex;
	}
	public void seteSex(String eSex) {
		this.eSex = eSex;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getePassword() {
		return ePassword;
	}
	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}
	public String getePhone() {
		return ePhone;
	}
	public void setePhone(String ePhone) {
		this.ePhone = ePhone;
	}
	public String geteCard() {
		return eCard;
	}
	public void seteCard(String eCard) {
		this.eCard = eCard;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String geteIndate() {
		return eIndate;
	}
	public void seteIndate(String eIndate) {
		this.eIndate = eIndate;
	}

	public int geteState() {
		return eState;
	}
	public void seteState(int eState) {
		this.eState = eState;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	public String geteOutdate() {
		return eOutdate;
	}
	public void seteOutdate(String eOutdate) {
		this.eOutdate = eOutdate;
	}
	public int getReadState() {
		return readState;
	}
	public void setReadState(int readState) {
		this.readState = readState;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
	
	
	
	
}
