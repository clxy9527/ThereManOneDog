package com.oa.mapper;

import java.util.HashMap;
import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Notice;

public interface NoticeMapper {
	public List<Notice> getAllNotice();
	public Notice findNoticeById();
	public List<Notice> findNoticeByState();
	public void deleteNotice();
	public void addNotice(Notice notice);
	public void addReaders(HashMap<String, Object> readers);
	public List<Employee> getReaders(int nId);
}
