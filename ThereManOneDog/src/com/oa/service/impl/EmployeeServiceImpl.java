package com.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.EmployeeMapper;
import com.oa.pojo.Employee;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	/**
	 * 登陆接口实现
	 */
	@Override
	public Employee selectEmployeeById(String eId) {
		Employee employee = employeeMapper.selectEmployeeById(eId);
		return employee;

	}
	/**
	 * 添加员工接口实现
	 */
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.addEmployee(employee);
				
	}
	/**
	 * 修改员工接口实现
	 */
	@Override
	public void updateEmployee(Employee employee ) {
		// TODO Auto-generated method stub
		employeeMapper.updateEmployee(employee);
	}
	/**
	 * 查询所有接口实现
	 */
	@Override
	public List<Employee> queryAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> list=employeeMapper.queryAllEmployee();		
		return list;
	}
	/**
	 * 按类型查询员工接口实现
	 */
	@Override
	public List<Employee> queryEmployeebyterm(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> list =employeeMapper.queryEmployeebyterm(employee);
		return list;
	}
	
	



}
