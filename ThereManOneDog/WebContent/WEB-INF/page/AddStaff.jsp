<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> 添加人员</title>
 
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
</head>
<body>
	<form role="form" class="form-inline" action="${pageContext.request.contextPath}/employeeController/addemployee.action">			
			
			
				<h4 class="modal-title" id="myModalLabel">
					添加员工
				</h4>
				<table width="100%" cellpadding="1" cellspacing="1">
				<tr>

			<td><label for="name">员工姓名:</label>
			<input type="text" style="width:180px;" name="eName" id ="eId" placeholder="请输入员工姓名">
			</td>
			  
			<td><label for="phone">电话号码:</label>
			<input type="text" style="width:180px;" name="ePhone" id ="ePhone" placeholder="请输入员工联系电话">
			</td>
			</tr>
		
			<tr>
			<td><label for="idcard">证件号码:</label>
			<input type="text"  style="width:180px;" name="eCard" id ="eCard" placeholder="请输入员工证件号码">
			
			</td><td><label for="address">所在住址:</label>
			<input type="text"  style="width:180px;" name="eAddress" id ="eAddress" placeholder="请输入员工住址">
</td>
</tr>
</table>
	<table width="100%" cellpadding="1" cellspacing="1" >
	<tr>
			<td> <label for="did" >所在部门:</label>
			
			 <select name="dId" >
				<option  selected>部门选择 </option>
					<c:forEach items="${departmentlist}" var="department" varStatus="no">  
			<option onclick="ajaxRequestPageadd('${department.getdId()}')"  value="${department.getdId()}"> ${department.getdName()},${department.getdId()}</option>	
            </c:forEach>   
		</select>		

	</td>
		<td>	<label for="pid" >部门职位</label>
			
				 <select name="pId"   id="position" class="form-control" >
				<option  selected>职位选择 </option>	
		</select>

	</td>
	</tr></table>
				<button  type="submit" class="btn btn-primary" >
					提交
				</button>

				<button type="reset" class="btn btn-default" >重置
				</button>
				
			
	</form>
<br>
<table width="100%" cellpadding="1" cellspacing="1">
<tr>
<td>
<form role="form" class="form-inline" action="${pageContext.request.contextPath}/departmentController/addedepartment.action">			
   <h4 class="modal-title" id="myModalLabel">
					添加部门
				</h4>
				
   <table >
	<tr>
			<td><label for="dName">新增部门</label>
			<input type="text"  style="width:180px;" name="dName" id ="dName" placeholder="请输入新部门">
			</td>
			</tr>
			<tr><td>
							<button  type="submit" class="btn btn-primary" >
					提交
				</button>

				<button type="reset" class="btn btn-default" >重置
				</button>
			</td></tr>
			</table>

   </form>
</td>
<td >
<form role="form" class="form-inline" action="${pageContext.request.contextPath}/positionController/addposition.action">			
   <h4 class="modal-title" id="myModalLabel">
					添加职位
				</h4>
   <table >
	<tr>
	<td>
	 <select name="dId" class="form-control">
				<option  selected>部门选择 </option>
					<c:forEach items="${departmentlist}" var="department" varStatus="no">  
			<option  value="${department.getdId()}"> ${department.getdName()},${department.getdId()}</option>	
            </c:forEach>   
		</select>	
		</td>	
			<td><label for="dName">新增职位</label>
			<input type="text"  style="width:180px;" name="pName" id ="pName" placeholder="请输入新职位">
			</td>
			</tr>
			</table>
			<table><tr><td>
				<button  type="submit" class="btn btn-primary" >
					提交
				</button>

				<button type="reset" class="btn btn-default" >重置
				</button>
				</tr>
				</table>
   </form></td>
</tr>
</table>
   
 <script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>