package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Department;

public interface DepartmentMapper {
	public List<Department> queryAllDepartment();//��ѯ���в���
	public void addDepaertment(Department department);//���Ӳ���
	public void deleteDepartment(int dId);//ɾ������
}
