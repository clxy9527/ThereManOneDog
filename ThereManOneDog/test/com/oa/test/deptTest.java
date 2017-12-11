package com.oa.test;

import java.util.ArrayList;
import java.util.List;

public class deptTest {
	private int Did;
	private String name;
	private List<employeeTest> employees = new  ArrayList<employeeTest>();
	
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<employeeTest> getEmployees() {
		return employees;
	}
	public void setEmployees(List<employeeTest> employees) {
		this.employees = employees;
	}
	

	
}
