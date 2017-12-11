package com.oa.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.pojo.Employee;
import com.oa.service.impl.EmployeeService;

public class EmployeeServiceTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	
	@Test
	public void loginTest(){
		Employee employee = new Employee();
		employee.seteid("T9527");
		employee.setEaddress("9527");
		EmployeeService employeeService = (EmployeeService) ac.getBean("employeeService");
		employeeService.login(employee);
	}
}
