package com.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oa.pojo.Employee;


public interface EmployeeService {
	public boolean login(Employee employee);//��½
	public void addEmployee(Employee employee);//���Ա������������������Ա
	public void updateEmployee(Employee employee);//����Ա����������������Ա��״̬��������Ϣ��
	public List<Employee> queryAllEmployee();//��ѯ����Ա���÷���
	public List<Employee> queryEmployeebyterm(Employee employee);//������ѯԱ��
	
}
