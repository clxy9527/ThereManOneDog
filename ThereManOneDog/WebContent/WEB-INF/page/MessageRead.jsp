<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
                    <div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">
                                    <h3>消息管理</h3>
                                </div>
                                <div class="module-option clearfix">
                                    <div class="pull-left">
                                        <div class="btn-group">
                                            <button class="btn" id="output">全部</button>
                                            <button class="btn dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="#" id="allMessage" onclick="MessageFilter('全部')" >全部</a></li>
                                                <li><a href="#" id="unReadMessage" onclick="MessageFilter('未读')">未读</a></li>
                                                <li><a href="#" id="ReadMessage" onclick="MessageFilter('已读')">已读</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="module-body table">
                                    <table class="table table-message">
                                        <thead>        
                                        <tr class="heading">
                                                <td class="cell-icon"></td>
                                                <td>发送人</td>
                                                <td>公告标题</td>
                                                <td>公告类型</td>
                                                <td>发送日期</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="notice" items="${allNotice}">
                                        <tr class="unread<c:if test="${notice.nImportant==1}"> starred</c:if>"  onclick="ajaxRequestPage('${pageContext.request.contextPath}/noticeController/getNoticeById.action?nId=${notice.nId}')">
                                                <td class="cell-check">
                                                <label  style="display:none;"><c:out value="${notice.nImportant}"></c:out></label>
                                                    <i class="icon-star"></i>
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                   <c:out value="${notice.getnAuthor().geteName()}" />
                                                </td>
                                                <td class="cell-title">
                                                    <c:out value="${notice.getnTitle()}" />
                                                </td>
                                                <td class="cell-title">
                                                    <c:out value="${notice.getnType()}" />
                                                </td>
                                                <td class="cell-time align-right">
                                                    <c:out value="${notice.getnTime()}" />
                                                </td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!--/.content-->
                    </div>
</body>
</html>