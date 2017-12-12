package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Notice;

public interface NotiveMapper {
	public List<Notice> getAll();
	public Notice findNoticeById();
	public List<Notice> findNoticeByState();
	public void deleteNotice();
	
	
}
