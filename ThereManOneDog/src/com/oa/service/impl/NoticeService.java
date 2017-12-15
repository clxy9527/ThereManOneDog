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
	
	/**
	 * 根据公告编号删除公告及阅读关系
	 * @param ids
	 */
	public void deleteNoticeByIds(List<Integer> ids);
	
	/**
	 * 将公告标记为已读
	 * @param eId员工编号
	 * @param nId公告编号
	 */
	public void readNotice(String eId,int nId);
}
