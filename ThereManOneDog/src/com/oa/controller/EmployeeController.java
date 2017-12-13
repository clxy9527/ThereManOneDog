package com.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Employee;
import com.oa.service.impl.EmployeeService;

@Controller
@RequestMapping("employeeController")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * ��½����
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		Employee dbEmployee = employeeService.selectEmployeeById(employee.geteId());
		if(dbEmployee.getePassword().equals(employee.getePassword())){
			request.getSession().setAttribute("eid", employee.geteId());
			modelAndView.setViewName("index");
			request.getSession().setAttribute("employee", employee);
		}else{
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	/**
	 *  ִ�����Ա������
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/addemployee")
	public ModelAndView addemployee(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.addEmployee(employee);
		modelAndView.addObject("employee",employee);
		modelAndView.setViewName("");
		return modelAndView;
}
	/**
	 * ִ���޸�Ա����Ϣ����
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/updateemployee")
	public ModelAndView updateemployee(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.updateEmployee(employee);
		modelAndView.addObject("employee",employee);
		modelAndView.setViewName("");
		return modelAndView;
}
	/**
	 * ִ�в�ѯ����Ա������
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryAllEmployee")
	public ModelAndView queryAllEmployee(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.queryAllEmployee();
		//��Ҫ�޸Ĵ���list
		modelAndView.addObject("employee",employee);
		modelAndView.setViewName("");
		return modelAndView;
	}
	/**
	 * ִ�и��ݲ��Ų�ѯԱ������
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryEmployeebyterm")
	public ModelAndView queryEmployeebyterm(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.queryEmployeebyterm(employee);
		//��Ҫ�޸Ĵ���list
		modelAndView.addObject("employee",employee);
		modelAndView.setViewName("");
		return modelAndView;
	}
}
