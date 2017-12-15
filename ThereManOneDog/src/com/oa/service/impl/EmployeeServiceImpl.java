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
	 * ��½�ӿ�ʵ��
	 */
	@Override
	public Employee selectEmployeeById(String eId) {
		Employee employee = employeeMapper.selectEmployeeById(eId);
		return employee;

	}
	/**
	 * ���Ա���ӿ�ʵ��
	 */
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.addEmployee(employee);
				
	}
	/**
	 * �޸�Ա���ӿ�ʵ��
	 */
	@Override
	public void updateEmployee(Employee employee ) {
		// TODO Auto-generated method stub
		employeeMapper.updateEmployee(employee);
	}
	/**
	 * ��ѯ���нӿ�ʵ��
	 */
	@Override
	public List<Employee> queryAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> list=employeeMapper.queryAllEmployee();		
		return list;
	}
	/**
	 * �����Ͳ�ѯԱ���ӿ�ʵ��
	 */
	@Override
	public List<Employee> queryEmployeebyterm(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> list =employeeMapper.queryEmployeebyterm(employee);
		return list;
	}
	
	



}
