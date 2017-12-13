package com.oa.service.impl;

import java.util.List;

import com.oa.pojo.Department;

public interface DepartmentService {
	public List<Department> queryAllDepartment();//查询所有部门
	public void addDepaertment(Department department);//增加部门
	public void deleteDepartment(int dId);//删除部门
}
