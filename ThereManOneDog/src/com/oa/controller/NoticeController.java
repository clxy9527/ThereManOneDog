package com.oa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Department;
import com.oa.pojo.Employee;
import com.oa.pojo.Notice;
import com.oa.service.impl.DepartmentService;
import com.oa.service.impl.EmployeeService;
import com.oa.service.impl.NoticeService;

@Controller
@RequestMapping("noticeController")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	

	@Autowired
	private EmployeeService EmployeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	/**
	 * 跳转公告发布页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addNotice")
	public ModelAndView addNotice(HttpServletRequest request, HttpServletResponse response){
		 HttpSession session = request.getSession();
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("release");
		 List<Department> departments  = departmentService.queryAllDepartment();
		 session.setAttribute("departments", departments);
		 return modelAndView;
	}
	
	/**根据部门查询员工列表
	 * @param request
	 * @param response
	 * @param dId 部门编号
	 * @return
	 */
	@RequestMapping("/getEmploeeByDepartment")
	public ModelAndView getEmployeeList(HttpServletRequest request,HttpServletResponse response , int dId){
		 HttpSession session = request.getSession();
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("EmployeeList");
		 Employee employee = new Employee();
		 employee.setdId(dId);
		 List<Employee> employees = EmployeeService.queryEmployeebyterm(employee);
		 session.setAttribute("employeelist", employees);
		 return modelAndView;
	}
	
	
	/**将新公告保存到数据库中
	 * @param request
	 * @param response
	 * @param notice公告内容
	 * @param selectEmployees相关人员的编号字符串集
	 * @return
	 */
	@RequestMapping("/saveNotice")
	public ModelAndView saveNotice(HttpServletRequest request,HttpServletResponse response,Notice notice ,String selectEmployees){
		 ModelAndView modelAndView = new ModelAndView();
		 System.out.println(selectEmployees);
		 notice.setnAuthor((Employee)request.getSession().getAttribute("employee"));
		 notice.setReaders(get_selected_employee(selectEmployees));
		 noticeService.addNotice(notice);
		 modelAndView.setViewName("getAllNotice");
		 return modelAndView;
	}
	
	/**获取所有的公告
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getAllNotice")
	public ModelAndView getAllNotice(HttpServletRequest request,HttpServletResponse response){
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("message");
		 List<Notice> notices = noticeService.getAllNotice();
		 modelAndView.addObject("allNotice", notices);
		 return modelAndView;
		
		
	}
	
	/**转换字符串编号为对象列表
	 * @param selected_employee
	 * @return
	 */
	public List<Employee> get_selected_employee(String selected_employee){
		List<String> result = Arrays.asList(selected_employee.split(","));
		if(result.get(0).equals(""))result=null;
		List<Employee> employees = new ArrayList<Employee>();
		if(selected_employee!=null){
			for(String id:result){
				Employee employee = new Employee();
				employee.seteId(id);
				employees.add(employee);
			}
		}
		return employees;
	}
	
	/**根据id字符串集查询对应的姓名集
	 * @param request
	 * @param response
	 * @param eIds
	 * @throws IOException
	 */
	@RequestMapping("getEmployeeNames")
	public void getEmployeeNames(HttpServletRequest request,HttpServletResponse response,String eIds) throws IOException{
		List<String> eIdList = Arrays.asList(eIds.split(","));
		String result = "";
		for(String  id:eIdList ){
			Employee employee = EmployeeService.selectEmployeeById(id);
			result += employee.geteName();
			result +=",";
		}
		response.setContentType("application/json;charset=UTF-8");
		result = result.substring(0,result.length()-1);
		System.out.println(result);
	    response.getWriter().append(""+result);
	}
}
