<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
                                            <button class="btn" id="outitem" >全部</button>
                                            <button class="btn dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="#" id="item1" >全部</a></li>
                                                <li><a href="#" id="item2" >未读</a></li>
                                                <li><a href="#" id="item3" >已读</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="pull-right">
                                        <a href="#" class="btn btn-primary" onclick="hide()" id="deal">通知处理</a>
                                        <a href="#" class="btn btn-primary" id="delete">删除</a>
                                    </div>
                                </div>
                                <div class="module-body table">
                                    <table class="table table-message">
                                        <thead>
                                         <tr class="heading">
                                                <td class="cell-check" >
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">发送人</td>
                                                <td class="cell-title">公告标题</td>
                                                <td class="cell-icon hidden-phone hidden-tablet">
                                                </td>
                                                <td class="cell-time align-right">发送日期</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="unread">
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                    <i class="icon-star"></i>
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    John Donga
                                                </td>
                                                <td class="cell-title">
                                                    Sample Work
                                                </td>
                                                <td class="cell-icon hidden-phone hidden-tablet">
                                                    <i class="icon-paper-clip"></i>
                                                </td>
                                                <td class="cell-time align-right">
                                                    18:24
                                                </td>
                                            </tr>
                                            <tr class="unread starred">
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                    <i class="icon-star"></i>
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    John Donga
                                                </td>
                                                <td class="cell-title">
                                                    Test Title
                                                </td>
                                                <td class="cell-icon hidden-phone hidden-tablet">
                                                    <i class="icon-paper-clip-no"></i>
                                                </td>
                                                <td class="cell-time align-right">
                                                    18:01
                                                </td>
                                            </tr>
                                            <tr class="read starred">
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                    <i class="icon-star"></i>
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    John Donga
                                                </td>
                                                <td class="cell-title">
                                                    Someone wants to talk to you!
                                                </td>
                                                <td class="cell-icon hidden-phone hidden-tablet">
                                                    <i class="icon-paper-clip-no"></i>
                                                </td>
                                                <td class="cell-time align-right">
                                                    May 21
                                                </td>
                                            </tr>
                                            <tr class="read">
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                    <i class="icon-star"></i>
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    John Doe
                                                </td>
                                                <td class="cell-title">
                                                    Doe wants to talk to you!
                                                </td>
                                                <td class="cell-icon hidden-phone hidden-tablet">
                                                    <i class="icon-paper-clip"></i>
                                                </td>
                                                <td class="cell-time align-right">
                                                    May 15
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="module-foot">
                                </div>
                            </div>
                        </div>
                        <!--/.content-->
                    </div>
</body>
</html>