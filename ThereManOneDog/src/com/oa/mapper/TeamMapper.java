package com.oa.mapper;

import com.oa.pojo.Team;

public interface TeamMapper {
	public Team selectTeamById(String tmId);
	
	public void createTeam(Team team);
	
	public void deleteTeam(String tmId);
}
