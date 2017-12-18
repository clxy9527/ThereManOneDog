package com.oa.mapper;

import java.util.HashMap;
import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Notice;

public interface NoticeMapper {
	public List<Notice> getAllNotice();
	public Notice findNoticeById(int nId);
	public List<Notice> findNoticeByEmployee(String eId);
	public List<Notice> findNoticeByState();
	public void deleteNotices(List<Integer> ids);
	public void deleteReaders(List<Integer> ids);
	public void addNotice(Notice notice);
	public void addReaders(HashMap<String, Object> readers);
	public List<Employee> getReaders(int nId);
	public void readNotice(HashMap<String, Object> readmap);
	public Notice findNoticeByNidAndEid(HashMap<String, Object> idmap);
	public List<Notice> findNoticeByEidAndState(HashMap<String, Object> readmap);
	public List<Notice> findNoticeByType(String type);
}
