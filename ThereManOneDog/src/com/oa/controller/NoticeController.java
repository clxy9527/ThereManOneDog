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
import org.springframework.web.bind.annotation.RequestParam;
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
		 notice.setnAuthor((Employee)request.getSession().getAttribute("employee"));
		 notice.setReaders(get_selected_employee(selectEmployees));
		 noticeService.addNotice(notice);
		 modelAndView.setViewName("index");
		 return modelAndView;
	}
	
	/**加载公告查看列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getAllNotice")
	public ModelAndView getAllNotice(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("MessageRead");
		 Employee employee = (Employee) session.getAttribute("employee");
		 List<Notice> notices = noticeService.findNoticeByEid(employee.geteId());
		 notices.size();
		 
		 
		 modelAndView.addObject("allNotice", notices);
		 return modelAndView;
	}
	
	/**加载公告管理界面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/noticeManger")
	public ModelAndView noticeManger(HttpServletRequest request,HttpServletResponse response){
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("MessageManger");
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
	@RequestMapping("/getEmployeeNames")
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
	
	/**
	 * 获取公告详细内容
	 * @param request
	 * @param response
	 * @param nId 公告id
	 * @return
	 */
	@RequestMapping("/getNoticeById")
	public ModelAndView getNoticeById(HttpServletRequest request,HttpServletResponse response,String nId){
		ModelAndView modelAndView = new ModelAndView();
		Notice notice = noticeService.findNoticeById(Integer.parseInt(nId));
		modelAndView.addObject("notice", notice);
		modelAndView.setViewName("NoticeLook");
		return modelAndView;
	}
	
	/**
	 * 获取公告详细内容并进行阅读
	 * @param request
	 * @param response
	 * @param nId 公告id
	 * @return
	 */
	@RequestMapping("/getNoticeByIdToRead")
	public ModelAndView getNoticeByIdToRead(HttpServletRequest request,HttpServletResponse response,String nId){
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		Notice notice = noticeService.findNoticeByNidAndEid(employee.geteId(), Integer.parseInt(nId));
		modelAndView.addObject("notice", notice);
		modelAndView.setViewName("NoticeRead");
		return modelAndView;
	}
	
	
	
	
	/**
	 * 删除公告及关系
	 * @param request
	 * @param response
	 * @param selectedNotice被选中的公告数组
	 * @return
	 */
	@RequestMapping("/deleteNotices")
	public ModelAndView deleteNotices(HttpServletRequest request,HttpServletResponse response,@RequestParam("selectedNotice") String[]  selectedNotice){
		ModelAndView modelAndView = new ModelAndView();
		List<Integer> ids = new ArrayList<Integer>();
		for(String id:selectedNotice){
			ids.add(Integer.parseInt(id));
		}
		noticeService.deleteNoticeByIds(ids);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	/**
	 * 将公告标记为已读
	 * @param request
	 * @param response
	 * @param nId公告编号
	 * @return
	 */
	@RequestMapping("/readNotice")
	public ModelAndView readNotice(HttpServletRequest request,HttpServletResponse response,String nId){
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		noticeService.readNotice(employee.geteId(), Integer.parseInt(nId));
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	/**
	 * 根据类型查看公告
	 * @param request
	 * @param response
	 * @param Type
	 * @return
	 */
	@RequestMapping("/noticeMangerByType")
	public ModelAndView noticeMangerByType(HttpServletRequest request,HttpServletResponse response, String Type){
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("MessageManger");
		 List<Notice> notices = noticeService.findNoticeByType(Type);
		 modelAndView.addObject("allNotice", notices);
		 return modelAndView;
		
		
	}
	

	/**
	 * 根据阅读状态查看公告列表
	 * @param request
	 * @param response
	 * @param readstate阅读状态
	 * @return
	 */
	@RequestMapping("/noticeMangerByReadState")
	public ModelAndView noticeMangerByReadState(HttpServletRequest request,HttpServletResponse response, String readstate){
		 HttpSession session = request.getSession();
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("MessageRead");
		 Employee employee = (Employee) session.getAttribute("employee");
		 List<Notice> notices = noticeService.findNoticeByEidAndState(employee.geteId(), Integer.parseInt(readstate));
		 
		 modelAndView.addObject("allNotice", notices);
		 return modelAndView;
		
		
	}
}
