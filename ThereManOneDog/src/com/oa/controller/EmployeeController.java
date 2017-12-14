package com.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Department;
import com.oa.pojo.Employee;
import com.oa.service.impl.DepartmentService;
import com.oa.service.impl.EmployeeService;
import com.oa.service.impl.PositionService;

@Controller
@RequestMapping("employeeController")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * ��½����
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView = new ModelAndView();
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
	public String addemployee(HttpServletRequest request,HttpServletResponse response,Employee employee,ModelAndView modelAndView){
		employeeService.addEmployee(employee);
		modelAndView.addObject("employee",employee);
		return "forward:queryAllEmployee.aciton";
}
	/**
	 * ִ���޸�Ա����Ϣ����
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/updateemployee")
	public String updateemployee(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		employeeService.updateEmployee(employee);
		modelAndView.addObject("employee",employee);
		//modelAndView.setViewName("Department");
		return "forward:queryAllEmployee.aciton";
}
	/**
	 * ִ�в�ѯ����Ա������
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryAllEmployee")
	public ModelAndView queryAllEmployee(HttpServletRequest request,HttpServletResponse response,Employee employee,Department department){
		ModelAndView modelAndView =new ModelAndView();
		//�޸Ĵ���list
		List<Employee> employeelist=  employeeService.queryAllEmployee();
		modelAndView.addObject("employeelist",employeelist);
		List<Department>  departmentlist=departmentService.queryAllDepartment();
		modelAndView.addObject("departmentlist",departmentlist);
		modelAndView.setViewName("StaffList");
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
	public ModelAndView queryEmployeebyterm(HttpServletRequest request,HttpServletResponse response,Employee employee,Department department,int dId){
		ModelAndView modelAndView =new ModelAndView();
		employee.setdId(dId);
		List<Employee> employeelist=employeeService.queryEmployeebyterm(employee);
		modelAndView.addObject("employeelist",employeelist);
		List<Department>  departmentlist=departmentService.queryAllDepartment();
		modelAndView.addObject("departmentlist",departmentlist);
		modelAndView.setViewName("StaffList");
		return modelAndView;
	}
}
