package com.oa.service.impl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.EmployeeMapper;
import com.oa.mapper.NoticeMapper;
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
	
	
	
	
	
}
