package com.oa.service.impl;

import java.util.List;

import com.oa.pojo.Position;

public interface PositionService {
	public void addposition(Position position);//添加岗位
	public void deleteposition(int pId,int dId);//删除岗位
	public List<Position> queryposition(int dId);//根据部门查岗位
}
