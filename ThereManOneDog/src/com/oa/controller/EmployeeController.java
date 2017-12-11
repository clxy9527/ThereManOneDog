package com.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Employee;
import com.oa.service.impl.EmployeeService;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("123465");
		ModelAndView modelAndView = new ModelAndView();
//		if(employeeService.login(employee)){
//			modelAndView.setViewName("/index");
//		}else{
//			modelAndView.setViewName("/login");
//		}
		return modelAndView;
	}
	
}
