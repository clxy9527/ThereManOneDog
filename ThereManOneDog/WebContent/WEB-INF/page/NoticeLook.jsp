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
                <div class="span9">
                    <div class="content">
                        <div class="module">
                            <div class="module-body">
                                <h2 class="text-center" align="center">${notice.getnTitle()}</h2>
                                <hr/>
                                <section class="docs">
                                    <div id="notive_info" align="center">
                                    <label >发布人：${notice.getnAuthor().geteName()}&nbsp;&nbsp;发布日期：${notice.getnTime()}</label>
                                    </div>
                                    <div>
                                    ${notice.getnContent()}
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                    <!--/.content-->
                </div>
</body>
</html>