package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Team;
import com.oa.pojo.TeamEmployee;

public interface TeamService {
	//����ID�����Ŷ���Ϣ
	public Team selectTeamById(String eId);
	//�����Ŷ�
	public void createTeam(Team team);
	//ɾ���Ŷ�
	public void deleteTeam(Integer tmId);
	
	//�����Ŷ�����
	public void changeTeamName(Team team);
	//ɾ���Ŷӳ�Ա
	public void deleteTeamMember(HashMap<String,Object> TeamEmployee);
	//�����û�����������Ŷ�
	public List<Team> selectAllTeamFromEmployee(String eId);
	//����Ŷӳ�Ա
	public void addTeamMember(HashMap<String,Object> TeamEmployee);
	//��ѯ�Ŷ��г�Ա
	public List<Employee> selectAllMenmberInTeam(Integer tmId);
	
	
	
	
}
