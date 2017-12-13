<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

    <c:forEach items="${employeelist}" var="employee" varStatus="no">
        <label class=" btn btn-default btn-block">
            <input name="employeeSelected" type="checkbox"  value="${employee.geteId()}" onclick="changeIds()" />
                                           员工号：${employee.geteId()}
                                            姓名：${employee.geteName()}
        </label>
    </c:forEach> 
</body>
</html>