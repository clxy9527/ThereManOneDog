<%@page import="com.oa.test.employeeTest"%>
<%@page import="com.oa.test.deptTest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%
    List<deptTest> depts =(List<deptTest>) session.getAttribute("dept_list");
    List<employeeTest> employeeTests = depts.get(1).getEmployees();
    System.out.print("call");
%>

<c:forEach var="employee" items="<%=employeeTests%>">
        <label class=" btn btn-default btn-block">
            <input name="employee_selected" type="checkbox" />
             ${employee.getName()}
        </label>
</c:forEach>
</body>
</html>