package com.oa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.PositionMapper;
import com.oa.pojo.Position;

@Service("positionService")
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionMapper positionMapper;
	/**
	 * ��Ӹ�λ
	 */
	@Override
	public void addposition(Position position) {
		// TODO Auto-generated method stub
		positionMapper.addposition(position);
	}
/**
 * ���ݲ���id�͸�λid ɾ����λ
 */
	@Override
	public void deleteposition(int pId, int dId) {
		// TODO Auto-generated method stub
		positionMapper.deleteposition(pId, dId);
	}
/**
 * ���ݲ��Ų�ѯ��λ
 */
	@Override
	public List<Position> queryposition(int dId) {
		// TODO Auto-generated method stub
		List<Position> list=positionMapper.queryposition(dId);
		return list;
	}

}
