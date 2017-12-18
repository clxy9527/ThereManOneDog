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
                                <hr />
                                 <h2 class="text-center" align="center">阅读情况一览</h2>
                                 <div class="module message">
                                 <div class="module-body table">
                                 <table class="table table-message">
                                        <tbody>
                                        <tr class="heading">
                                                <td class="cell-title">员工号</td>
                                                <td class="cell-title">员工姓名</td>
                                                <td class="cell-title">阅读情况</td>
                                        </tr>
                                        <c:forEach var="reader" items="${notice.readers}">
                                        <tr class="unread">
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                   <c:out value="${reader.eId}" />
                                                </td>
                                                <td class="cell-title">
                                                    <c:out value="${reader.eName}" />
                                                </td>
                                                <td class="cell-title">
                                                <c:if test="${reader.readState==0 }">未读</c:if>
                                                <c:if test="${reader.readState==1 }">已读</c:if>
                                                </td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--/.content-->
                    
                </div>
</body>
</html>