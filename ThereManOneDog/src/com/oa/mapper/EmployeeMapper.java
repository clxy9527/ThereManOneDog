package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Employee;



public interface EmployeeMapper {
	public Employee selectEmployeeById(String eid);//��½��ѯ���ݿ���֤�Ƿ���ȷ
	public void addEmployee(Employee employee);//���Ա������������������Ա
	public void updateEmployee(Employee employee);//����Ա����������������Ա��״̬��������Ϣ��
	public List<Employee> queryAllEmployee();//��ѯ����Ա���÷���
	public List<Employee> queryEmployeebyterm(Employee employee);//������ѯԱ��
	
}
