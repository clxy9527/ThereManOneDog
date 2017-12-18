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
	
	/**
	 * 根据公告编号和员工编号查询公告
	 * @param eid员工编号
	 * @param nid公告编号
	 * @return
	 */
	public Notice findNoticeByNidAndEid(String eid,int nid);
	
	/**
	 * 根据员工编号和状态获取公告
	 * @param eid 员工编号
	 * @param readstate 阅读状态
	 * @return
	 */
	public List<Notice> findNoticeByEidAndState(String eid , int readstate);
	
	/**
	 * 根据公告类型获取公告
	 * @param type 公告类型
	 * @return
	 */
	public List<Notice> findNoticeByType(String type);
}
