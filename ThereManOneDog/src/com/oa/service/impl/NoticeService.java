package com.oa.service.impl;

import java.util.List;

import com.oa.pojo.Notice;

public interface NoticeService {
	
	/**
	 * @param notice 要发布的公告
	 */
	public void addNotice(Notice notice);
	
	
	/**
	 * 获取所有公告
	 * @return
	 */
	public List<Notice> getAllNotice();
}
