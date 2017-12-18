package com.oa.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.pojo.Employee;
import com.oa.pojo.Notice;
import com.oa.service.impl.NoticeService;
import com.oa.util.TimeUtil;

public class NoticeServiceTest {

	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
//	
//	@Test
//	public void addNoticeTest(){
//		
//		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
//		
//		noticeService.addNotice(createData());
//	}
//	
//	
//	public Notice createData(){
//		Notice notice = new Notice();
//		notice.setnTitle("测试001");
//		notice.setnContent("测试数据");
//		notice.setnType("公告");
//		notice.setnTime(TimeUtil.getTime());
//		notice.setnImportant(0);
//		notice.setnReadState(0);
//		
//		
//		
//		Employee author = new Employee();
//		author.seteId("T9527");
//		notice.setnAuthor(author);
//		
//		Employee e1 = new Employee();
//		e1.seteId("T0010");
//		
//		Employee e2 = new Employee();
//		e2.seteId("T0048");
//		
//		List<Employee> employees = new ArrayList<Employee>();
//
//		employees.add(e1);
//		employees.add(e2);
//		
//		notice.setReaders(employees);
//		
//		notice.getReaders().get(1).geteId();
//		
//		return notice;
//	}
	
	
//	
//	@Test
//	public void getAllNotice(){
//		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
//		noticeService.getAllNotice();
//	}
	
//	@Test
//	public void getNoticeById(){
//		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
//		noticeService.findNoticeById(16);
//	}
	
//	@Test
//	public void deleteNotice(){
//		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(14);
//		ids.add(15);
//		ids.add(16);
//		noticeService.deleteNoticeByIds(ids);
//	}
//	
	@Test
	public void findNoticeByIdToRead(){
		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
		List<Notice> notices = noticeService.findNoticeByType("决定");
		System.out.println(notices.size()+"1");
	}
//	
//	@Test
//	public void readTest(){
//		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
//		noticeService.readNotice("T9527", 17);
//	}
	
	
//	@Test
//	public void findNoticeByIdToRead(){
//		NoticeService noticeService = (NoticeService) ac.getBean("noticeService");
//		Notice n = noticeService.findNoticeByNidAndEid("T9527", 17);
//		n.getnAuthor();
//	}
}

