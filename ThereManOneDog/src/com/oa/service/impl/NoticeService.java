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
	
	
	/**
	 * 根据公告编号获取公告
	 * @param nId 公告编号
	 * @return
	 */
	public Notice findNoticeById(int nId);
	
	/**根据员工编号获取公告
	 * @param eId员工编号
	 * @return
	 */
	public List<Notice> findNoticeByEid(String eId);
}
