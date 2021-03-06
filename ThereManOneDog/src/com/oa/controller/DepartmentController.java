package com.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Department;
import com.oa.pojo.Position;
import com.oa.service.impl.DepartmentService;
import com.oa.service.impl.PositionService;

@Controller
@RequestMapping("/departmentController")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	/**
	 *  执行添加部门操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/addedepartment")
	public ModelAndView addedepartment(HttpServletRequest request,HttpServletResponse response,Department department){
		ModelAndView modelAndView =new ModelAndView();
		departmentService.addDepaertment(department);
		modelAndView.addObject("department",department);
		modelAndView.setViewName("index");
		return modelAndView;
}
	/**
	 *  执行查询部门操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryAllDepartment")
	public ModelAndView queryAllDepartment(HttpServletRequest request,HttpServletResponse response,Department department){
		ModelAndView modelAndView =new ModelAndView();
		List<Department>  departmentlist=departmentService.queryAllDepartment();
		//需要修改传递list
		modelAndView.addObject("departmentlist",departmentlist);
		modelAndView.setViewName("AddStaff");
		return modelAndView;
}
	/**
	 *  执行删除部门操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/deleteDepartment")
	public ModelAndView deleteDepartment(HttpServletRequest request,HttpServletResponse response,Department department){
		int dId=0;
		ModelAndView modelAndView =new ModelAndView();
		departmentService.deleteDepartment(dId);
		modelAndView.addObject("department",department);
		modelAndView.setViewName("index");
		return modelAndView;
}
	
}
