package com.oa.pojo;

import java.util.Date;

public class Team {
	private int tmId;
	private String tmName;
	private String tmDescribe;
	private String tmTime;
	private String eId;
	public int getTmId() {
		return tmId;
	}
	public void setTmId(int tmId) {
		this.tmId = tmId;
	}
	public String getTmName() {
		return tmName;
	}
	public void setTmName(String tmName) {
		this.tmName = tmName;
	}
	public String getTmDescribe() {
		return tmDescribe;
	}
	public void setTmDescribe(String tmDescribe) {
		this.tmDescribe = tmDescribe;
	}
	public String getTmTime() {
		return tmTime;
	}
	public void setTmTime(String tmTime) {
		this.tmTime = tmTime;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}


}
