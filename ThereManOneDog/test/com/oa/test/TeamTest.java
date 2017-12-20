package com.oa.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.mapper.TeamMapper;
import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.pojo.TeamEmployee;
import com.oa.service.impl.TeamService;

public class TeamTest {
	TeamMapper teamMapper;
	ApplicationContext ac=null;
	@Before
	public void init(){
		
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	
	@Test
	public void createTeam(){
		HashMap<String , Object>teamInfo=new HashMap<String,Object>();
		teamInfo.put("tmid",5);
		teamInfo.put("tmName", "������");
		teamInfo.put("tmDescribe", "���������");
		teamInfo.put("tmTime", "2017-12-14");
		teamInfo.put("eId", "T9527");	
		TeamService teamService=(TeamService)ac.getBean("teamService");
		//teamService.createTeam(teamInfo);
		
	}
	
	@Test
	public void SelectAllTeamFromEmployee(){
		TeamService teamService=(TeamService)ac.getBean("teamService");
		List<Team> list=teamService.selectAllTeamFromEmployee("T9527");
		for(Iterator iterator = list.iterator(); iterator.hasNext();){
			Team team=(Team) iterator.next();
			System.out.println("==========");
			System.out.println(team.getTmName());
			System.out.println("==========");
		}
		
	}
	
	@Test
	public void selectAllMenmberInTeam(){
		TeamService teamService=(TeamService)ac.getBean("teamService");
		List<Employee> list=teamService.selectAllMenmberInTeam(2);
		for(Iterator iterator = list.iterator(); iterator.hasNext();){
			Employee employee=(Employee)iterator.next();
			System.out.println("==========");
			System.out.println(employee.geteId());
			System.out.println("==========");
		}
	}
	@Test 
	public void changeTeamName(){
		TeamService teamService=(TeamService)ac.getBean("teamService");
		Team team=new Team();
		team.setTmId(4);
		team.setTmName("��������");
		teamService.changeTeamName(team);
	}
	@Test
	public void addTeamMember(){
		TeamService teamService=(TeamService)ac.getBean("teamService");
		HashMap<String , Object>TeamEmployee=new HashMap<String,Object>();
		TeamEmployee.put("eId", "T788");
		TeamEmployee.put("tmId", 2);
		teamService.addTeamMember(TeamEmployee);
	
	}
	@Test
	public void deleteTeamMember(){
		TeamService teamService=(TeamService)ac.getBean("teamService");
		HashMap<String , Object>TeamEmployee=new HashMap<String,Object>();
		TeamEmployee.put("tmId", 4);
		TeamEmployee.put("eId", "T9527");
		teamService.deleteTeamMember(TeamEmployee);
	}
}
