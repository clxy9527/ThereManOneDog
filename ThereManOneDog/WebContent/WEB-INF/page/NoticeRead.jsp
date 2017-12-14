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
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ajax.js"></script>
</head>
<body>

<div id="notive_title" class="row">
    <h2 class="text-center">${notice.getnTitle()}</h2>
</div>
<div id="notive_info" class="row text-uppercase">
<form action="" style=""></form>
    <label class="col-md-4">发布人：${notice.getnAuthor().geteName()}</label>
    <label class="col-md-4">发布日期：${notice.getnTime()}</label>
</div>
<div  class="row lead">
    内容：${notice.getnContent()}
</div>
<div id="notive_function" align="center" class="navbar-fixed-bottom">
    <a class="col-md-3 col-md-offset-5 btn btn-success" href="Notive_servlet?method=Noitve_read&id=%>&state=已读" onClick="w_close()" >已读</a>
</div>
</body>
</html>