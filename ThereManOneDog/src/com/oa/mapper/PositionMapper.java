package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Position;

public interface PositionMapper {
	public void addposition(Position position);//��Ӹ�λ
	public void deleteposition(int pId,int dId);//ɾ����λ
	public List<Position> queryposition(int dId);//���ݲ��Ų��λ
}
