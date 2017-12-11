package com.oa.pojo;

import java.util.Date;

public class Employee {
	private String Eid;
	private String Ename;
	private String Epassword;
	private String Ephone;
	private String Ecard;
	private int pid;
	private int did;
	private Date Eindate;
	private Date EoutDate;
	private int Estate;
	private String Eaddress;
	
	
	public String getEid() {
		return Eid;
	}
	public void setEid(String eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEpassword() {
		return Epassword;
	}
	public void setEpassword(String epassword) {
		Epassword = epassword;
	}
	public String getEphone() {
		return Ephone;
	}
	public void setEphone(String ephone) {
		Ephone = ephone;
	}
	public String getEcard() {
		return Ecard;
	}
	public void setEcard(String ecard) {
		Ecard = ecard;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public Date getEindate() {
		return Eindate;
	}
	public void setEindate(Date eindate) {
		Eindate = eindate;
	}
	public Date getEoutDate() {
		return EoutDate;
	}
	public void setEoutDate(Date eoutDate) {
		EoutDate = eoutDate;
	}
	public int getEstate() {
		return Estate;
	}
	public void setEstate(int estate) {
		Estate = estate;
	}
	public String getEaddress() {
		return Eaddress;
	}
	public void setEaddress(String eaddress) {
		Eaddress = eaddress;
	}
	
	
	
	
}
