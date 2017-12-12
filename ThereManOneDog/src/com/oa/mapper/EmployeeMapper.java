package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Employee;



public interface EmployeeMapper {
	public Employee selectEmployeeById(String eid);//登陆查询数据库验证是否正确
	public void addEmployee(Employee employee);//添加员工方法，包括行政人员
	public void updateEmployee(Employee employee);//更新员工方法，包括更新员工状态和其他信息。
	public List<Employee> queryAllEmployee();//查询所有员工得方法
	public List<Employee> queryEmployeebyterm(Employee employee);//条件查询员工
	
}
