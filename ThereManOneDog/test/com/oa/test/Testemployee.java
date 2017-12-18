package com.oa.test;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Employee;
import com.oa.service.impl.EmployeeService;
import com.oa.util.EidUtil;


public class Testemployee {
		ApplicationContext ac=null;
		@Before
		public void init(){
			ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
		}
//		@Test
//		public void addTest(){
//			Employee employee = new Employee();
//			employee.seteId("T788");
//			employee.seteName("³Â");
//			employee.setePassword("6969");
//			employee.setpId(48);
//			employee.setdId(48);
//			employee.seteIndate("2017-10-12");
//			employee.seteCard("154878748422");
//			employee.setePhone("1541515541");
//			employee.seteState(1);
//			EmployeeService employeeService = (EmployeeService) ac.getBean("employeeService");
//			employeeService.addEmployee(employee);
//		}
//		@Test
//		public void updateTest(){
//			Employee employee=new Employee();
//			employee.seteId("T9527");
//			employee.setePassword("9227");
//			employee.seteState(0);
//			employee.seteAddress("Ñ§12328");
//			employee.seteOutdate("2017-12-12");
//			EmployeeService employeeService=(EmployeeService) ac.getBean("employeeService");
//			employeeService.updateEmployee(employee);
//		}
		@Test 
		public void queryAllEmployee(){
			EmployeeService employeeService=(EmployeeService) ac.getBean("employeeService");
			List<Employee> list= employeeService.queryAllEmployee();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println(employee.geteId()+ "\t" + employee.geteName());
			}
		}
//		@Test 
//		public void queryEmployeebyterm(){
//			Employee employee =new Employee();
//			employee.setdId(48);
//			EmployeeService employeeService=(EmployeeService) ac.getBean("employeeService");
//			List<Employee> list= employeeService.queryEmployeebyterm(employee);
//			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//				Employee employee2 = (Employee) iterator.next();
//				System.out.println(employee2.geteId()+ "\t" + employee2.geteName()+"\t"+ employee2.getdId());
//			}
//		}
//		@Test 
//		public void until(){
//			String eid=EidUtil.getRandomString(2);
//			System.out.println(eid);
//		}
}


