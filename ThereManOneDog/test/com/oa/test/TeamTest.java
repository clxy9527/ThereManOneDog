package com.oa.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.pojo.Team;
import com.oa.service.impl.TeamService;

public class TeamTest {

	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	@Test
	public void createTeam(){
		Team team=new Team();
		team.setTmId(4);
		team.setTmName("jtest");
		team.setTmDescribe("≤‚ ‘”√");
		team.setTmId(2017-12-13);
		TeamService teamService=(TeamService)ac.getBean("teamService");
		teamService.createTeam(team,"T9527");
		
	}
	
	@Test
	public void changeTeamName(){
		
	}
}
