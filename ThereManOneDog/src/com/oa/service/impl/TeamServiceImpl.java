package com.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.TeamMapper;
import com.oa.pojo.Team;

@Service("teamService")
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamMapper teamMapper;

	@Override
	public Team selectTeamById(String eId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTeam(Team team,String eId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeam(Integer tmId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTeamName(int tmId,String tmName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTeamMember(Integer emId, Integer eId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeamMember(Integer tmId,String eId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void  selectAllTeamFromEmployee(String eId){
		
	}
	
	

}
