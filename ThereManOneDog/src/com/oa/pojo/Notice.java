package com.oa.pojo;

import java.util.Date;
import java.util.List;

public class Notice {
	private int nId;
	private String nTitle;
	private Employee nAuthor;//Ô±¹¤id
	private String nContent;
	private Date nTime;
	private String nType;
	private String nImportant;
	private int nReadState;
	private List<Employee> readers;
	
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public Employee getnAuthor() {
		return nAuthor;
	}
	public void setnAuthor(Employee nAuthor) {
		this.nAuthor = nAuthor;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Date getnTime() {
		return nTime;
	}
	public void setnTime(Date nTime) {
		this.nTime = nTime;
	}
	public String getnType() {
		return nType;
	}
	public void setnType(String nType) {
		this.nType = nType;
	}
	public String getnImportant() {
		return nImportant;
	}
	public void setnImportant(String nImportant) {
		this.nImportant = nImportant;
	}
	public int getnReadState() {
		return nReadState;
	}
	public void setnReadState(int nReadState) {
		this.nReadState = nReadState;
	}
	public List<Employee> getReaders() {
		return readers;
	}
	public void setReaders(List<Employee> readers) {
		this.readers = readers;
	}
	
	
	
}
