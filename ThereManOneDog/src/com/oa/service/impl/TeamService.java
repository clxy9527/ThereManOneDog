package com.oa.service.impl;

import com.oa.pojo.Team;

public interface TeamService {
	public Team selectTeamById(String eId);
	public void createTeam(Team team,String eId);
	public void deleteTeam(Integer tmId);
	public void changeTeamName(int tmId,String tmName);
	public void addTeamMember(Integer emId,Integer eId);
	public void deleteTeamMember(Integer tmId,String eId);
	public void selectAllTeamFromEmployee(String eId);
	
	
}
