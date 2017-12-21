<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/datatables/jquery.dataTables.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
	
</head>
<body>
<body>



					<div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">
                                    <h3> 团队管理</h3>
                                </div>
                                <div class="module-option clearfix">
                                    <div class="pull-right">
                                        <div class="btn-group">
                                            <button class="btn" style="size: 20px" id="listName" value="Team" onclick="">选择团队</button>
                                            <button class="btn dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" value="Team">
                                            <c:forEach items="${allTeam}" var="team" varStatus="no">
                                            	<li><a href="#" onclick="TeamMangement('${pageContext.request.contextPath}/teamController/selectAllMenmberInTeam.action?tmId=${team.tmId}','${team.tmName}')" id="${team.tmName}">${team.tmName}</a></li>
                                            </c:forEach>
                                               
                                               
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="pull-right">
                                       <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#createNewTeam">新建团队</a>
                                        <button type="button" class="btn btn-danger" id="deleteTeam" value=""  onclick="ajaxDeleteTeam('${pageContext.request.contextPath}/teamController/deleteTeam.action?tmId=${tmId}')">删除团队</button>
                                    </div>
                                </div>
                                
                                <form action="${pageContext.request.contextPath}/teamController/deleteTeamMember.action">
                                    <table class="table table-message" >
                                    <thead>
                                       
                                            <tr class="heading">
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox" id="teamMemberSelect" >
                                                    <input  type="hidden"  name="tmId" value="${tmId}" >
                                                </td>
                                                <td class="cell-title">
                                                 	员工编号
                                                </td>
                                                <td class="cell-title">
                                                 	姓名
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                  	  入职时间
                                                </td>
                                              
                                               
                                            </tr>
                                            </thead>
                                           <tbody>
                                           <c:forEach items="${employeelist}" var="employee" varStatus="no">
                                           		<tr>
                                           		<td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox" name="userId" value="${employee.eId}">
                                                </td>
                                                <td class="cell-title">
                                                   ${employee.eId}
                                                </td>
                                                <td class="cell-title">
                                                   ${employee.eName}
                                                </td>
                                               
                                                 <td class="cell-title">
                                                  ${employee.eIndate}
                                                </td>
                                              
                                               
                                           			
                                           		</tr>
                                           
                                           </c:forEach>
                                           
                                        </tbody>
                                        
                                    </table>
                               
                                 	<div style="margin: 5px;" align="right">
                                     <a  class="btn btn-primary" id="addMemberButoon"  data-toggle="modal" data-target="#myModal">新增成员</a>
                                    <input  type="submit"class="btn btn-danger" id="deleteMemberButton" value="删除成员" />
                                    </div>
                                    </form>
                                         </div>
                                    </div>
                                </div>
                           
              

<!-- 模态框（Modal） -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog"  >
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加员工
				</h4>
			</div>
			<div class="modal-body" style="overflow: auto;">
			<table>
			    <tr>
			    <td colspan="3">
                    <div class="col-md-6">         
                        <ul class="nav nav-pills nav-stacked">
                        <c:forEach items="${departments}" var="dept" varStatus="no">
                            <li>
                            <a  data-toggle="tab" onclick="ajaxRequestPageWithChecked('${pageContext.request.contextPath}/noticeController/getEmploeeByDepartment.action?dId=${dept.getdId()}')">${dept.getdName()}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                </td>
                <td>
                <div id="EmployeeList" class="col-md-4">
                </div>
                 </td>
                </tr>
                </table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="ajaxAddTeamMember('${pageContext.request.contextPath}/teamController/addTeamMember.action?tmId=${tmId}&selected_employee=')">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- 模态框（Modal） -->

<div class="modal fade" id="createNewTeam" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog"  >
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					创建团队
				</h4>
			</div>
			<form id="TeamInfo"style="vertical-align:middle;margin: 20px;"  action="${pageContext.request.contextPath}/teamController/createTeam.action">
			<div class="modal-body" style="overflow: auto;">
			<table>
			    <tr>
			    <td colspan="3">
                    <div class="col-md-6">         
                           			<table align="center" >
                           				<tbody>
                           					<tr style="border:0px;">
                           						<td>团队名称</td>
                           						<td><input type="text" name="teamName"></td>
                           					</tr>
                           					<tr>
                           						<td>团队创建日期:</td>
                           						<td><input type="Date" name="createDate"></td>
                           					</tr>
                           					<tr>
                           						<td>团队描述:</td>
                           						<td>
                           							<textarea rows="" cols="" name="teamD"></textarea>
                           						
                           						</td>
                           						
                           					</tr>
                           					<tr>
                           						<td>
                           						
                           						</td>
                           						<td>
                           						<button type="reset" class="btn btn-default" >取消</button>
                           						<input type="submit" class="btn btn-primary" value="提交更改" />
                           						</td>
                           						
                           					</tr>
                           					
                           					</tbody>
                           					
				
                           					</table>         					
                </div>
                </td>
                </tr>
                </table>
                
			</div>
			</form>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->

</div>	
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"style="display: none;"  >
	<div class="modal-dialog"  >
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加员工
				</h4>
			</div>
			<div class="modal-body" style="overflow: auto;">
			<table>
			    <tr>
			    <td colspan="3">
                    <div class="col-md-6">         
                        <ul class="nav nav-pills nav-stacked">
                        <c:forEach items="${departments}" var="dept" varStatus="no">
                            <li>
                            <a  data-toggle="tab" onclick="ajaxRequestPageWithChecked('${pageContext.request.contextPath}/noticeController/getEmploeeByDepartment.action?dId=${dept.getdId()}')">${dept.getdName()}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                </td>
                <td>
                <div id="EmployeeList" class="col-md-4">
                </div>
                 </td>
                </tr>
                </table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="ajaxRequestNames('${pageContext.request.contextPath}/noticeController/getEmployeeNames.action?eIds=')">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

</div>



</body>
</html>