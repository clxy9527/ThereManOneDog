package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.EmployeeMapper;
import com.oa.mapper.NoticeMapper;
import com.oa.pojo.Employee;
import com.oa.pojo.Notice;
import com.oa.util.TimeUtil;
import com.sun.javafx.collections.MappingChange.Map;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	


	


	@Override
	public void addNotice(Notice notice) {
		notice.setnTime(TimeUtil.getTime());
		noticeMapper.addNotice(notice);
		System.out.println(notice.getReaders().get(0).geteId());
		
		HashMap<String, Object> map = new  HashMap<String, Object>();
		
		System.out.println(notice.getnId());
		map.put("nId", notice.getnId());
		map.put("readers", notice.getReaders());
		map.put("nReadState",notice.getnReadState());
		noticeMapper.addReaders(map);
	}


	@Override
	public List<Notice> getAllNotice() {
		List<Notice> notices = noticeMapper.getAllNotice();
		for(Notice notice:notices){
			List<Employee> employees = noticeMapper.getReaders(notice.getnId());
			notice.setReaders(employees);
		}
		return notices;
	}


	@Override
	public Notice findNoticeById(int nId) {
		Notice notice = noticeMapper.findNoticeById(nId);
		List<Employee> employees = noticeMapper.getReaders(nId);
		notice.setReaders(employees);
		return notice;
	}


	@Override
	public List<Notice> findNoticeByEid(String eId) {
		List<Notice> notices = noticeMapper.findNoticeByEmployee(eId);
		return notices;
	}


	@Override
	public void deleteNoticeByIds(List<Integer> ids) {
		noticeMapper.deleteReaders(ids);
		noticeMapper.deleteNotices(ids);
	}


	@Override
	public void readNotice(String eId, int nId) {
		
		HashMap<String, Object> map = new  HashMap<String, Object>();
		map.put("nId", nId);
		map.put("eId", eId);
		map.put("readstate",1);
		noticeMapper.readNotice(map);
	}


	@Override
	public Notice findNoticeByNidAndEid(String eid, int nid) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("eId", eid);
		map.put("nId", nid);
		
		return noticeMapper.findNoticeByNidAndEid(map);
	}


	@Override
	public List<Notice> findNoticeByEidAndState(String eid, int readstate) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("eId", eid);
		map.put("readstate",readstate);
		return noticeMapper.findNoticeByEidAndState(map);
	}


	@Override
	public List<Notice> findNoticeByType(String type) {
		List<Notice> notices = noticeMapper.findNoticeByType(type);
		for(Notice notice:notices){
			List<Employee> employees = noticeMapper.getReaders(notice.getnId());
			notice.setReaders(employees);
		}
		return notices;
	}

	
}
