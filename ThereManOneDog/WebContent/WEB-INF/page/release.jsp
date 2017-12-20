<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<html>
<%
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
    <style type="text/css">
<!--
.STYLE1 {font-size: 12px}
a:link {
color: #FFFFFF;
text-decoration: none;
}
a:visited {
text-decoration: none;
}
a:hover {
text-decoration: none;
}
a:active {
text-decoration: none;
}
-->
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Edmin</title>
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ajax.js"></script>
</head>
<body>
<form   action="${pageContext.request.contextPath}/noticeController/saveNotice.action" method="post">
				<table align="center" border="1" >
    <tr>
        <td>标题：</td>
        <td width="500px">
        <input type="text" name="nTitle" placeholder="请输入标题内容" width="80px"/>
        </td>
    </tr>
    <tr>
        <td>类别：</td>
        <td>
            <select name="nType">
                <option value=""></option>
                <option value="决定">决定</option>
                <option value="通知">通知</option>
                <option value="报告">报告</option>
                <option value="其他">其他</option>
            </select>
        </td>
    </tr>
    <tr>
            <td>重要公告</td>
        <td>
            <select name="nImportant">
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>发布范围
        </td>
        <td>
        <textarea id="employeeLink" readonly="readonly" style="80%" ></textarea>
        <textarea id="selectEmployees" name="selectEmployees" readonly="readonly" style="display:none;" ></textarea>
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加人员</button>
        </td>
    </tr> 
    <tr height="200px">
    <td colspan="2"><textarea name="nContent" cols="100" rows="8"  style="width:700px;height:500px;visibility:hidden;resize: none;"><%=htmlspecialchars(htmlData)%></textarea></td>
    </tr>
    <tr>
        <td align="center" colspan="2">
        <input class="btn btn-success" type="submit" value="确定" />
        </td>
    </tr>
</table>
</form>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog"  >
		<div class="modal-content" >
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
</body>
</html>