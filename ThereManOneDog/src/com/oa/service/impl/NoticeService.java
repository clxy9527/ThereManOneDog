package com.oa.service.impl;

import java.util.List;

import com.oa.pojo.Notice;

public interface NoticeService {
	
	/**
	 * @param notice Ҫ�����Ĺ���
	 */
	public void addNotice(Notice notice);
	
	
	/**
	 * ��ȡ���й���
	 * @return
	 */
	public List<Notice> getAllNotice();
}
