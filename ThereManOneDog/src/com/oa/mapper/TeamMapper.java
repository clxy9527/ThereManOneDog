package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Team;

public interface TeamMapper {
	public Team selectTeamById(String tmId);
	
	public List<Team> selectAllTeamFromEmployee(String eId);
	
	public List<Employee> selectAllMenmberInTeam(Integer tmId);
	
	public void createTeam(Team team,String eId);
	
	public void deleteTeam(String tmId);
	
	public void changeTeamName(int tmId,String tmName);
	
	public void addTeamMember(String tmId,String eId);
	
	public void deleteTeamMember(String tmid,String eId);
	
	
	
}
