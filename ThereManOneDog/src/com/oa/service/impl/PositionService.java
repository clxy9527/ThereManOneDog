package com.oa.service.impl;

import java.util.List;

import com.oa.pojo.Position;

public interface PositionService {
	public void addposition(Position position);//��Ӹ�λ
	public void deleteposition(int pId,int dId);//ɾ����λ
	public List<Position> queryposition(int dId);//���ݲ��Ų��λ
}
