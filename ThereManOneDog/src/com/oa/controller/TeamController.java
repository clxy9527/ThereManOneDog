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
		System.out.println("���ò�ѯָ���Ŷӷ���");
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
		System.out.println("���ò�ѯԱ�������Ŷӷ���");
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
		System.out.println("���ô����Ŷӷ�������");
		String EID=request.getParameter("eid");
		teamService.createTeam(team, EID);
		
	}
	@RequestMapping("/deleteTeam")
	public void deleteTeam(HttpServletRequest request,HttpServletResponse response){
		System.out.println("����ɾ���Ŷӷ�������");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		teamService.deleteTeam(TMID);
	}
	@RequestMapping("/changeTeamName")
	public void changeTeamName(HttpServletRequest request,HttpServletResponse response){
		System.out.println("���ø����Ŷӷ�������");
		String tmName=request.getParameter("tmName");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		teamService.changeTeamName(TMID,tmName);
		
	}
	/*
	public void addTeamMember(HttpServletRequest request,HttpServletResponse response){
		System.out.println("�����Ŷ���ӳ�Ա����");
		List<Team> teamList=new ArrayList<Team>();
		request.getParameter(arg0);
	}*/
	@RequestMapping("/deleteTeamMember")
	public void deleteTeamMember(HttpServletRequest request,HttpServletResponse response){
		System.out.println("�����Ŷ���ӳ�Ա����");
		Integer TMID=Integer.valueOf(request.getParameter("tmId"));
		String EID=request.getParameter("eid");
	}
	
	

}
