<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.oa.test.deptTest"%>
    <%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="scripts/jquery-1.9.1.min.js"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="scripts/datatables/jquery.dataTables.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="css/theme.css" rel="stylesheet">
	<link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>

</head>
<body>

					<div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">
                                    <h3>新建任务清单</h3>
                                </div>
                                <div class="module-body table">
                           
                           			<form style="vertical-align:middle;margin: 20px;">
                           			<table align="center" >
                           				<tbody>
                           					<tr style="border:0px;">
                           						<td>起始日期:</td>
                           						<td><input type="Date" name="startDate">为空为当前日期</td>
                           					</tr>
                           					<tr>
                           						<td>结束日期:</td>
                           						<td><input type="Date" name="endDate">为空则不结束</td>
                           					</tr>
                           					<tr>
                           						<td>任务内容:</td>
                           						<td>
                           							<textarea rows="" cols=""></textarea>
                           							<div style="color: red">此处不可空白</div>
                           						</td>
                           						
                           					</tr>
                           					<tr>
                           						<td>参与者:</td>
                           						<td><input type="text" readonly="readonly" name="taskMember"><a style="color: blue" data-toggle="modal" data-target="#myModal">+添加</a>   <a style="color: grey">清空</a></td>
                           					</tr>
                           					<tr>
                           						<td>任务提醒:</td>
                           						<td style="text-align: center;"><input type="checkbox" name="taskAlerm">发送任务提醒</td>
                           					</tr>
                           					<tr>
                           						<td >
                           							<button class="btn btn-primary" type="submit">确定</button>
                           							<button type="button">重置</button>
                           						</td>
                           					</tr>
                           				</tbody>
                           			</table>
                           		
                           			</form>
                                    </div>
                                </div>
                             
                            </div>
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->
        <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 300px">
	<div class="modal-dialog" style="width: 300px" >
		<div class="modal-content" style="width: 300px">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body" style="overflow: auto;">
			<table>
			    <tr>
			    <td colspan="3">
                    <div class="col-md-6">         
                        <ul class="nav nav-pills nav-stacked">
                        <c:forEach items="${dept_list}" var="dept" varStatus="no">
                            <li>
                            <a  data-toggle="tab" onclick="loadEmployeePage('${no.index}')">${dept.getName()}</a>
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
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<% List<deptTest> list = (List<deptTest>) session.getAttribute("dept_list");
   System.out.print(list.size());
%>				
</body>
</html>