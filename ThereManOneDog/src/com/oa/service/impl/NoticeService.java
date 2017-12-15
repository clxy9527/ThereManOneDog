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
	
	
	/**
	 * ���ݹ����Ż�ȡ����
	 * @param nId ������
	 * @return
	 */
	public Notice findNoticeById(int nId);
	
	/**����Ա����Ż�ȡ����
	 * @param eIdԱ�����
	 * @return
	 */
	public List<Notice> findNoticeByEid(String eId);
	
	/**
	 * ���ݹ�����ɾ�����漰�Ķ���ϵ
	 * @param ids
	 */
	public void deleteNoticeByIds(List<Integer> ids);
	
	/**
	 * ��������Ϊ�Ѷ�
	 * @param eIdԱ�����
	 * @param nId������
	 */
	public void readNotice(String eId,int nId);
}
