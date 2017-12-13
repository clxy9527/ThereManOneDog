package com.oa.test;

import java.util.ArrayList;
import java.util.List;

import com.oa.pojo.Employee;
import com.oa.pojo.Notice;
import com.oa.util.TimeUtil;

public class TestData {

	public static void main(String[] args) {
		Notice notice = new Notice();
		notice.setnTitle("测试001");
		notice.setnContent("测试数据");
		notice.setnType("公告");
		notice.setnTime(TimeUtil.getTime());
		notice.setnImportant(0);
		notice.setnReadState(0);
		
		
		
		Employee author = new Employee();
		author.seteId("T9527");
		notice.setnAuthor(author);
		
		Employee e1 = new Employee();
		e1.seteId("T0010");
		
		Employee e2 = new Employee();
		e2.seteId("T0048");
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(e1);
		employees.add(e2);
		
		notice.setReaders(employees);
		
		System.out.println(notice.getReaders().get(0).geteId());
	}
}
