package com.oa.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.pojo.Department;
import com.oa.service.impl.DepartmentService;

public class TestDepartment {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	@Test
	public void queryAllDepartment(){
		DepartmentService departmentService=(DepartmentService) ac.getBean("departmentService");
		List<Department> list = departmentService.queryAllDepartment();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Department department = (Department) iterator.next();
			System.out.println(department.getdId()+"\t"+department.getdName());
		}
	}
	@Test
	public void addDepaertment(){
		Department department=new Department();
		department.setdId(6);
		department.setdName("城管大队");
		DepartmentService departmentService=(DepartmentService) ac.getBean("departmentService");
		departmentService.addDepaertment(department);
	}
	@Test
	public void deleteDepartment(){
		int dId=6;
		DepartmentService departmentService=(DepartmentService) ac.getBean("departmentService");
		departmentService.deleteDepartment(dId);
		
	}
}
