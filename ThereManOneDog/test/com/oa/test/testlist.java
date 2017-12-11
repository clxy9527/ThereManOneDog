package com.oa.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testlist
 */
@WebServlet("/testlist")
public class testlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<deptTest> deptlist = new ArrayList<deptTest>();
		deptTest d1 = new deptTest();
		d1.setDid(1);
		d1.setName("部门A");
		employeeTest e1 = new employeeTest();
		e1.setName("员工01");
		employeeTest e2 = new employeeTest();
		e2.setName("员工02");
		d1.getEmployees().add(e1);
		d1.getEmployees().add(e2);
		
		System.out.println(d1.getEmployees().get(1).getName());
		
		deptTest d2 = new deptTest();
		d2.setDid(2);
		d2.setName("部门B");
		employeeTest e3 = new employeeTest();
		e3.setName("员工03");
		employeeTest e4 = new employeeTest();
		e4.setName("员工04");
		d2.getEmployees().add(e3);
		d2.getEmployees().add(e4);
		
		deptlist.add(d1);
		deptlist.add(d2);
		
		HttpSession session = request.getSession();
		session.setAttribute("dept_list", deptlist);
		
		request.getRequestDispatcher("indexxzw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
