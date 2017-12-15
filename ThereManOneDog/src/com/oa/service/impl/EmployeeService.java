package com.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oa.pojo.Employee;


public interface EmployeeService {
	public Employee selectEmployeeById(String eId);//登陆
	public void addEmployee(Employee employee);//添加员工方法，包括行政人员
	public void updateEmployee(Employee employee);//更新员工方法，包括更新员工状态和其他信息。
	public List<Employee> queryAllEmployee();//查询所有员工得方法
	public List<Employee> queryEmployeebyterm(Employee employee);//条件查询员工

}
