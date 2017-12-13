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
	 * 添加岗位
	 */
	@Override
	public void addposition(Position position) {
		// TODO Auto-generated method stub
		positionMapper.addposition(position);
	}
/**
 * 根据部门id和岗位id 删除岗位
 */
	@Override
	public void deleteposition(int pId, int dId) {
		// TODO Auto-generated method stub
		positionMapper.deleteposition(pId, dId);
	}
/**
 * 根据部门查询岗位
 */
	@Override
	public List<Position> queryposition(int dId) {
		// TODO Auto-generated method stub
		List<Position> list=positionMapper.queryposition(dId);
		return list;
	}

}
