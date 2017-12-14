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
       <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog"  >
		<div class="modal-content">
			<div class="modal-header">
			
				<h4 class="modal-title" id="myModalLabel"  >
					添加员工
				</h4>
			</div>
			<div class="modal-body" style="overflow: auto">
			
			<form role="form" class="form-inline">
			<div class="form-group">
			<label for="name">员工姓名</label>
			<input type="text" style="width:180px;" id ="eId" placeholder="请输入员工姓名">
			<label for="phone">电话号码</label>
			<input type="text" style="width:180px;" id ="ePhone" placeholder="请输入员工联系电话">
			<label for="idcard">证件号码</label>
			<input type="text"  style="width:180px;" id ="eCard" placeholder="请输入员工证件号码">
			<label for="address">所在住址</label>
			<input type="text"  style="width:180px;" id ="eAddress" placeholder="请输入员工住址">
	<table>
	<tr>
			<td><label for="did"  class="form-control">所在部门</label></td>
			<td><div class="container-fluid" > 
			<div>
			<ul class="nav navbar-nav" >
			<li class="dropdown"  >
				<a  id="depart" href="#"  class="dropdown-toggle" data-toggle="dropdown">
				部门选择
					<b class="caret" ></b>
				</a>
				<ul class="dropdown-menu" style="width:180px;" >
					<c:forEach items="${departmentlist}" var="department" varStatus="no">  
								<li><a onclick="ajaxRequestPageadd('${pageContext.request.contextPath}/positionController/queryposition.action?dId=${department.getdId()}','${department.getdName()}')"> ${department.getdName()}</a> </li>  
								
            </c:forEach>  
				</ul>
			</li>
		</ul>
	</div>
	</div>
	</td>
	</tr>
</table>
			<label for="pid" style="width:180px;">部门职位</label>
			<div class="container-fluid"> 
			<div>
			<ul class="nav navbar-nav" >
			<li class="dropdown"  >
				<a href="#"  class="dropdown-toggle" data-toggle="dropdown">
				职位选择
					<b class="caret" ></b>
				</a>
				<ul class="dropdown-menu">
					<c:forEach items="${positionlist}" var="position" varStatus="no">  
								<li>${position.getpName()}</li>  
            </c:forEach>  
				</ul>
			</li>
		</ul>
	</div>
	</div>
			</div>
			</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
    
 <script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>