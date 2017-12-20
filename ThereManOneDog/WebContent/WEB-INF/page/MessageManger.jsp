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
<form action="${pageContext.request.contextPath}/noticeController/deleteNotices.action" method="get">
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
                                                <li><a href="#" id="all" onclick="ajaxRequestPageWithTableHide('${pageContext.request.contextPath}/noticeController/noticeManger.action')" >全部</a></li>
                                                <li><a href="#" id="unReadMessage" onclick="MessageFilterManger('${pageContext.request.contextPath}/noticeController/noticeMangerByType.action?Type=公告','公告')">公告</a></li>
                                                <li><a href="#" id="ReadMessage" onclick="MessageFilterManger('${pageContext.request.contextPath}/noticeController/noticeMangerByType.action?Type=通知','通知')">通知</a></li>
                                                <li><a href="#" id="ReadMessage" onclick="MessageFilterManger('${pageContext.request.contextPath}/noticeController/noticeMangerByType.action?Type=决定','决定')">决定</a></li>
                                                <li><a href="#" id="ReadMessage" onclick="MessageFilterManger('${pageContext.request.contextPath}/noticeController/noticeMangerByType.action?Type=其他','其他')">其他</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="pull-right">
                                        <input type="button" class="btn btn-primary" onclick="hide()" id="deal" value="通知处理" />
                                        <input type="submit" class="btn btn-primary" id="delete"  value="删除" />
                                    </div>
                                </div>
                                <div class="module-body table">
                                    <table class="table table-message">
                                        <thead>        
                                        <tr class="heading">
                                                <td class="cell-check" ></td>
                                                <td class="cell-icon"></td>
                                                <td>发送人</td>
                                                <td>公告标题</td>
                                                <td>公告类型</td>
                                                <td>发送日期</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="notice" items="${allNotice}">
                                        <tr class="unread<c:if test="${notice.nImportant==1}" > starred</c:if>">
                                                <td class="cell-check">
                                                    <input name="selectedNotice" type="checkbox" class="inbox-checkbox" value="${notice.nId}">
                                                </td>
                                                <td class="cell-check"  onclick="ajaxRequestPage('${pageContext.request.contextPath}/noticeController/getNoticeById.action?nId=${notice.nId}')">
                                                <label  style="display:none;"><c:out value="${notice.nImportant}"></c:out></label>
                                                    <i class="icon-star"></i>
                                                </td>
                                                <td class="cell-title"  onclick="ajaxRequestPage('${pageContext.request.contextPath}/noticeController/getNoticeById.action?nId=${notice.nId}')">
                                                   <c:out value="${notice.getnAuthor().geteName()}" />
                                                </td>
                                                <td class="cell-title"  onclick="ajaxRequestPage('${pageContext.request.contextPath}/noticeController/getNoticeById.action?nId=${notice.nId}')">
                                                    <c:out value="${notice.getnTitle()}" />
                                                </td>
                                                <td class="cell-title"  onclick="ajaxRequestPage('${pageContext.request.contextPath}/noticeController/getNoticeById.action?nId=${notice.nId}')">
                                                    <c:out value="${notice.getnType()}" />
                                                </td>
                                                <td class="cell-time align-right"  onclick="ajaxRequestPage('${pageContext.request.contextPath}/noticeController/getNoticeById.action?nId=${notice.nId}')">
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
                    </form>
</body>
</html>