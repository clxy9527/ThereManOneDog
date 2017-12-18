package com.oa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Department;
import com.oa.pojo.Employee;
import com.oa.pojo.Position;
import com.oa.service.impl.DepartmentService;
import com.oa.service.impl.EmployeeService;
import com.oa.service.impl.PositionService;
import com.oa.util.EidUtil;
import com.oa.util.TimeUtil;

@Controller
@RequestMapping("employeeController")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	
	/**
	 * 登陆方法
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,Employee employee) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		Employee dbEmployee = employeeService.selectEmployeeById(employee.geteId());
		if(dbEmployee.geteState()==1&&dbEmployee.getePassword().equals(employee.getePassword())){
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
	public String addemployee(HttpServletRequest request,HttpServletResponse response,Employee employee,ModelAndView modelAndView){
		String eId=EidUtil.getRandomString(2);
		employee.seteId(eId);
		employee.setePassword("123456");
		String date=TimeUtil.getTime();
		employee.seteIndate(date);
		employee.seteState(1);
		employeeService.addEmployee(employee);
		modelAndView.addObject("employee",employee);
		return "index";
}
	/**
	 * 执行修改员工信息操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/updateemployee")
	public String updateemployee(HttpServletRequest request,HttpServletResponse response,Employee employee){
		ModelAndView modelAndView =new ModelAndView();
		if(employee.geteState()==0){
			employee.seteOutdate(TimeUtil.getTime());
		}
		employeeService.updateEmployee(employee);
		modelAndView.addObject("employee",employee);
		//modelAndView.setViewName("Department");
		return "index";
}
	/**
	 * 执行查询所有员工操作
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryAllEmployee")
	public ModelAndView queryAllEmployee(HttpServletRequest request,HttpServletResponse response,Employee employee,Department department){
		ModelAndView modelAndView =new ModelAndView();
		//修改传递list
		List<Employee> employeelist=  employeeService.queryAllEmployee();
		modelAndView.addObject("employeelist",employeelist);
		List<Department>  departmentlist=departmentService.queryAllDepartment();
		modelAndView.addObject("departmentlist",departmentlist);
		modelAndView.setViewName("StaffList");
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
	
	/**
	 * 进去页面
	 * @param request
	 * @param response
	 * @param employee
	 * @return
	 */
	@RequestMapping("/querybyid")
	public ModelAndView querybyid(HttpServletRequest request,HttpServletResponse response,Employee employee,Department department){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(employee.geteId());
		Employee dbEmployee = employeeService.selectEmployeeById(employee.geteId());
		List<Department> departmentlist=departmentService.queryAllDepartment();
		List<Position> positionlist= positionService.queryposition(employee.getdId());
		modelAndView.addObject("dbEmployee",dbEmployee);
		modelAndView.addObject("departmentlist",departmentlist);
		modelAndView.addObject("positionlist",positionlist);
		modelAndView.setViewName("StaffDetail");
		return modelAndView;
	}
}
