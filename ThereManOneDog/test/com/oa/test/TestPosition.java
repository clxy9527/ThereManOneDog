package com.oa.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.oa.pojo.Position;
import com.oa.service.impl.PositionService;

public class TestPosition {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	@Test
	public void queryposition(){
		Position position=new Position();
		position.setpId(16);
		position.setdId(48);
		position.setpName("º∆–≈œµ");
		PositionService positionService=(PositionService) ac.getBean("positionService");
		positionService.addposition(position);
		
	}
}
