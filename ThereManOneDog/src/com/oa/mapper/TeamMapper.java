package com.oa.mapper;

import java.util.HashMap;
import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.pojo.TeamEmployee;

public interface TeamMapper {
	public Team selectTeamById(String tmId);
	
	public List<Team> selectAllTeamFromEmployee(String eId);
	
	public List<Employee> selectAllMenmberInTeam(Integer tmId);
	
	public void createTeam(Team team);
	
	public void deleteTeam(Integer tmId);
	public void deleteTeam2(Integer tmId);
	
	public void changeTeamName(Team team);
	
	public void addTeamMember(HashMap<String,Object> TeamEmployee);
		
	public void deleteTeamMember(HashMap<String,Object> TeamEmployee);
	
	
	
}
