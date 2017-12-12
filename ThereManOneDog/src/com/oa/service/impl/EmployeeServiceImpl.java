package com.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.EmployeeMapper;
import com.oa.pojo.Employee;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public boolean login(Employee employee) {
		Employee dbEmployee = employeeMapper.selectEmployeeById(employee.geteId());
		if(dbEmployee.getePassword().equals(employee.getePassword())){
			return true;
		}else{
			return false;
		}

	}



}
