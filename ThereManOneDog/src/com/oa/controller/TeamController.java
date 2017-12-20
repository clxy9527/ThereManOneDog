package com.oa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Department;
import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.service.impl.DepartmentService;
import com.oa.service.impl.EmployeeService;
import com.oa.service.impl.TeamService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/teamController")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private EmployeeService EmployeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/selectTeamById")
	public ModelAndView SelectTeamById(HttpServletRequest request,HttpServletResponse response,Team team){
		System.out.println("调用查询指定团队方法");
		ModelAndView modelAndView = new ModelAndView();
		String EID=request.getParameter("eid");
		System.out.println("EID");
		teamService.selectTeamById(EID);
		modelAndView.addObject("team", team);
		modelAndView.setViewName("");	
		return modelAndView;		
	}
	
	@RequestMapping("/selectAllTeamFromEmployee")
	public ModelAndView SelectAllTeamFromEmployee(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		System.out.println("调用查询员工所有团队方法");
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		System.out.println(employee.geteId().toString());
		List<Team> teamList=teamService.selectAllTeamFromEmployee(employee.geteId().toString());
		for(Iterator<Team> iterator = teamList.iterator(); iterator.hasNext();){
			Team team=(Team) iterator.next();
			System.out.println("==========");
			System.out.println(team.getTmName());
			System.out.println("==========");
			}
		List<Department> departments  = departmentService.queryAllDepartment();
		 session.setAttribute("departments", departments);
		modelAndView.addObject("allTeam",teamList);
		modelAndView.setViewName("TeamTable");
		return modelAndView;
		
	}
	@RequestMapping("/createTeam")
	public ModelAndView createTeam(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		String eId=employee.geteId();
		String tmName=request.getParameter("teamName");
		String tmTime=request.getParameter("createDate");
		String tmDescribe=request.getParameter("teamD");
		
		System.out.println("调用创建团队方法方法");
		Team team=new Team();
		team.seteId(eId);
		team.setTmDescribe(tmDescribe);
		team.setTmName(tmName);
		team.setTmTime(tmTime);
		teamService.createTeam(team);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/deleteTeam")
	public ModelAndView deleteTeam(HttpServletRequest request,HttpServletResponse response,String tmId){
		System.out.println("调用删除团队方法方法");
		ModelAndView modelAndView = new ModelAndView();
		Integer TMID=Integer.valueOf(tmId);
		teamService.deleteTeam(TMID);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping("/changeTeamName")
	public void changeTeamName(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用更新团队方法方法");
		Team team=new Team();
		String tmName=request.getParameter("tmName");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		teamService.changeTeamName(team);
		
	}
	@RequestMapping("/addTeamMember")
	public void addTeamMember(HttpServletRequest request,HttpServletResponse response,String tmId,String selected_employee){
		System.out.println("调用团队添加成员方法");
		System.out.println(tmId);
		List<String> result = Arrays.asList(selected_employee.split(","));
		if(result.get(0).equals(""))result=null;
		List<Employee> select_employees = new ArrayList<Employee>();
		if(selected_employee!=null){
			for(String id:result){
				Employee employee = new Employee();
				employee.seteId(id);
				select_employees.add(employee);
			}
		}
		HashMap<String, Object> TeamEmployee=new HashMap<>();
		for(Iterator<Employee> iterator = select_employees.iterator(); iterator.hasNext();){
			Employee employee=(Employee) iterator.next();
			TeamEmployee.put("tmId", tmId);
			TeamEmployee.put("eId", employee.geteId());
			teamService.addTeamMember(TeamEmployee);
			}
		
		
		
	}
	@RequestMapping("/deleteTeamMember")
	public ModelAndView deleteTeamMember(HttpServletRequest request,HttpServletResponse response,@RequestParam("userId") String[]  userId){
		System.out.println("调用团队删除成员方法");
		String testID=request.getParameter("userId");
		String TMID=request.getParameter("tmId");
		System.out.println(TMID);
		System.out.println(testID);
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> TeamEmployee=new HashMap<>();
		for(int i = 0;i<userId.length;i++){	
			TeamEmployee.put("tmId", TMID);
			TeamEmployee.put("eId", userId[i].toString());
			teamService.deleteTeamMember(TeamEmployee);
			}
		for(Map.Entry entry:TeamEmployee.entrySet()){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/selectAllMenmberInTeam")
	public ModelAndView selectAllMenmberInTeam(HttpServletRequest request,HttpServletResponse response,Integer tmId,Employee employee){
		int TMID=Integer.valueOf(request.getParameter("tmId"));
		employee = (Employee)request.getSession().getAttribute("employee");
		System.out.println("==========");
		System.out.println(TMID);
		System.out.println("==========");
		ModelAndView modelAndView = new ModelAndView();
		
		List<Employee> employeelist=teamService.selectAllMenmberInTeam(tmId);
		modelAndView.addObject("employeelist",employeelist);
		
		for(Iterator<Employee> iterator = employeelist.iterator(); iterator.hasNext();){
			
			Employee employee2=(Employee) iterator.next();
			System.out.println("==========");
			System.out.println(employee2.geteName());
			System.out.println("==========");
			}
		
		List<Team> teamList=teamService.selectAllTeamFromEmployee(employee.geteId().toString());
		modelAndView.addObject("allTeam",teamList);
		
		modelAndView.addObject("tmId", tmId);
		modelAndView.setViewName("TeamTable");
		
		
		return modelAndView;
	}
	@RequestMapping("/redirect")
	public ModelAndView redirect(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.setViewName("TeamTable");
		return modelAndView;
	}
	
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
	

}
