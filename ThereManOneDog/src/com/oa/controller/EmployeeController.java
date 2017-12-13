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
	 * 登陆方法
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
	 *  执行添加员工操作
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
	 * 执行修改员工信息操作
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
	 * 执行查询所有员工操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryAllEmployee")
	public ModelAndView queryAllEmployee(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.queryAllEmployee();
		//需要修改传递list
		modelAndView.addObject("employee",employee);
		modelAndView.setViewName("");
		return modelAndView;
	}
	/**
	 * 执行根据部门查询员工操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryEmployeebyterm")
	public ModelAndView queryEmployeebyterm(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.queryEmployeebyterm(employee);
		//需要修改传递list
		modelAndView.addObject("employee",employee);
		modelAndView.setViewName("");
		return modelAndView;
	}
}
