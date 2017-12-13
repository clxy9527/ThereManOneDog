package com.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.service.impl.TeamService;

@Controller
@RequestMapping("/teamController")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/SelectTeamById")
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
	
	@RequestMapping("/SelectAllTeamFromEmployee")
	public ModelAndView SelectAllTeamFromEmployee(HttpServletRequest request,HttpServletResponse response,Team team){
		System.out.println("调用查询员工所有团队方法");
		ModelAndView modelAndView = new ModelAndView();
		List<Team> teamList=new ArrayList<Team>();
		String EID=request.getParameter("eid");
		System.out.println("EID");
		teamService.selectAllTeamFromEmployee(EID);
		modelAndView.addObject("allTeam",teamList);
		modelAndView.setViewName("");
		return modelAndView;
		
	}
	@RequestMapping("/createTeam")
	public void createTeam(HttpServletRequest request,HttpServletResponse response,Team team){
		System.out.println("调用创建团队方法方法");
		String EID=request.getParameter("eid");
		teamService.createTeam(team, EID);
		
	}
	@RequestMapping("/deleteTeam")
	public void deleteTeam(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用删除团队方法方法");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		teamService.deleteTeam(TMID);
	}
	@RequestMapping("/changeTeamName")
	public void changeTeamName(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用更新团队方法方法");
		String tmName=request.getParameter("tmName");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		teamService.changeTeamName(TMID,tmName);
		
	}
	/*
	public void addTeamMember(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用团队添加成员方法");
		List<Team> teamList=new ArrayList<Team>();
		request.getParameter(arg0);
	}*/
	@RequestMapping("/deleteTeamMember")
	public void deleteTeamMember(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用团队添加成员方法");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		String EID=request.getParameter("eid");
	}
	
	

}
