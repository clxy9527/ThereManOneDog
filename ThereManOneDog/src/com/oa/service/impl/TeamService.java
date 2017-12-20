package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.pojo.TeamEmployee;

public interface TeamService {
	//根据ID查找团队信息
	public Team selectTeamById(String eId);
	//创建团队
	public void createTeam(Team team);
	//删除团队
	public void deleteTeam(Integer tmId);
	
	//更改团队名称
	public void changeTeamName(Team team);
	//删除团队成员
	public void deleteTeamMember(HashMap<String,Object> TeamEmployee);
	//查找用户加入的所有团队
	public List<Team> selectAllTeamFromEmployee(String eId);
	//添加团队成员
	public void addTeamMember(HashMap<String,Object> TeamEmployee);
	//查询团队中成员
	public List<Employee> selectAllMenmberInTeam(Integer tmId);
	
	
	
	
}
