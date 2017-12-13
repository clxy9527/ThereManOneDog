package com.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.DepartmentMapper;
import com.oa.pojo.Department;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 查询部门
	 */
	@Override
	public List<Department> queryAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> list= departmentMapper.queryAllDepartment();
		return list;
	}
/**
 * 添加部门
 */
	@Override
	public void addDepaertment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.addDepaertment(department);
	}
	/**
	 * 删除部门
	 */
	@Override
	public void deleteDepartment(int dId) {
		departmentMapper.deleteDepartment(dId);
		// TODO Auto-generated method stub
		
	}

}
