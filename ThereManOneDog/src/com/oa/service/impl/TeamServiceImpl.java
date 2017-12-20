package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.TeamMapper;
import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.pojo.TeamEmployee;

@Service("teamService")
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamMapper teamMapper;

	@Override
	public Team selectTeamById(String eId) {
		// TODO Auto-generated method stub
		Team team=teamMapper.selectTeamById(eId);
		return team;
	}

	@Override
	public void createTeam(Team team) {
		// TODO Auto-generated method stub
		teamMapper.createTeam(team);
		
		System.out.println(team.getTmId());
		HashMap<String, Object> map = new  HashMap<String, Object>();
		map.put("tmID",team.getTmId());
		map.put("eId", team.geteId());
		teamMapper.addTeamMember(map);
		
		
	}

	@Override
	public void deleteTeam(Integer tmId) {
		// TODO Auto-generated method stub
		teamMapper.deleteTeam2(tmId);
		teamMapper.deleteTeam(tmId);
		
	}

	@Override
	public void changeTeamName(Team team) {
		// TODO Auto-generated method stub
		teamMapper.changeTeamName(team);
		
	}

	@Override
	public void addTeamMember(HashMap<String,Object> TeamEmployee) {
		// TODO Auto-generated method stub
		teamMapper.addTeamMember(TeamEmployee);
	}

	@Override
	public void deleteTeamMember(HashMap<String,Object> TeamEmployee) {
		// TODO Auto-generated method stub
		teamMapper.deleteTeamMember(TeamEmployee);
		
	}
	@Override
	public List<Team>  selectAllTeamFromEmployee(String eId){
		List<Team> list=teamMapper.selectAllTeamFromEmployee(eId);
		return list;
		
	}
	@Override
	public List<Employee>  selectAllMenmberInTeam(Integer tmId){
		List<Employee> list=teamMapper.selectAllMenmberInTeam(tmId);
		return list;
	}

	



	
	

}
