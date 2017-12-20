<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>员工详细信息</title>
 <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>


            <script>
		$(document).ready(function() {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
		} );
	</script>
	 <script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<form role="form" class="form-inline" action="${pageContext.request.contextPath}/employeeController/updateemployee.action">			
			 <div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">  
			<h4 class="modal-title" id="myModalLabel">
					修改员工信息
				</h4>
			
			<table>
			<tr>
			<td>员工编号:<input type="text" name="eId" value="${dbEmployee.geteId()}"  readonly>   </td>
			<td>员工姓名:<input type="text" name="eName" value="${dbEmployee.geteName()}"></td>
			<td>登陆密码:<input type="text" name="ePassword" value="${dbEmployee.getePassword()}"></td>
			</tr>
			</table>
			
				<table>
			<tr>
			<td>员工电话:<input type="number" maxlength="11"   name="ePhone" value="${dbEmployee.getePhone()}"  >   </td>
			<td>证件号码:<input type="number" maxlength="18"  name="eCard" value="${dbEmployee.geteCard()}"></td>
			<td>常住地址:<input type="text" name="eAddress" value="${dbEmployee.geteAddress()}"></td>
			</tr>
			</table>
			<table>
			<tr>
			<td>入职日期:<input type="text" name="eIndate" value="${dbEmployee.geteIndate()}"  readonly>   </td>
			<td>离职日期:<input type="text" name="eOutdate" value="${dbEmployee.geteOutdate()}" readonly></td>
		<td>离职日期:<input type="text" name="eSex" value="${dbEmployee.geteSex()}" readonly></td>
			</tr>
			</table>
			
			<table>
			<tr>
			<td>
			部门：<select name="dId" >				
					<c:forEach items="${departmentlist}" var="department" varStatus="no">  
			<option 
			<c:if test="${dbEmployee.getDepartment().getdName() == department.getdName()}">selected="selected"</c:if>
			onclick="ajaxRequestPageadd('${department.getdId()}')"  value="${department.getdId()}"> ${department.getdName()}
			</option>	
            </c:forEach>     
		</select>		</td>
		<td>
				
		 岗位：<select name="pId" id="position"   >
		 <c:forEach items="${positionlist}" var="position" varStatus="no"> 
				<option 
			<c:if test="${dbEmployee.getPosition().getpName() == position.getpName()}">selected="selected"</c:if>
		  value="${position.getpId()}"> ${position.getpName()}
			</option>
					 </c:forEach>	
		</select></td>
			<td>在职状态:	<select name="eState" >			
			<option 
			<c:if test="${dbEmployee.geteState() == 1}">selected="selected"</c:if>
			 value="1"> 在职
			</option>	
        <option 
			<c:if test="${dbEmployee.geteState() == 0}">selected="selected"</c:if>
			 value="0"> 已离职
			</option>
			</select>	</td>
			</tr>
			</table>
			<table align="center" ><tr><td>
				<button  type="submit" class="btn btn-primary" >
					提交
				</button>

				<button type="reset" class="btn btn-default" >重置
				</button>
				</tr>
				</table>
			</div></div></div></div>
				
				</form>
</body>
</html>