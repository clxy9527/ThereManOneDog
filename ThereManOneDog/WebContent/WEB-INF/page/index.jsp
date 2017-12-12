<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ThereManOneDog</title>
        <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
        <link type="text/css" href="">
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ajax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/datatables/jquery.dataTables.js"></script>
<script charset="utf-8" src="./kindeditor-4.1.7/jquery.js"></script>

</head>
<body>
<body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i>
                        </a>
                         <a class="btn btn-navbar" data-toggle="collapse2" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i>
                        </a>
                         <a class="btn btn-navbar" data-toggle="collapse3" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i>
                        </a>
                        <!-- 这个是 方法 -->
                        <a class="brand" href="/WEB-INF/page/index.jsp">ThereManOneDog </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                        <ul class="nav nav-icons">
                            <li class="active"><a href="#"><i class="icon-envelope"></i></a></li>
                            <li><a href="#"><i class="icon-eye-open"></i></a></li>
                            <li><a href="#"><i class="icon-bar-chart"></i></a></li>
                        </ul>
                       
                        <ul class="nav pull-right">
  </ul>
                    </div>
                    <!-- /.nav-collapse -->
                </div>
            </div>
            <!-- /navbar-inner -->
        </div>
        <!-- /navbar -->
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <div class="sidebar">
                                           <!-- 这里有一个 -->      
                            <ul class="widget widget-menu unstyled">
                                <li>
                                <a class="collapsed" data-toggle="collapse" href="#togglePages1">
                                <i class="menu-icon icon-cog"></i>
                                <i class="icon-chevron-down pull-right"></i>
                                <i class="icon-chevron-up pull-right"></i>
                                人事管理
								</a>
                                    <ul id="togglePages1" class="collapse unstyled">
                                    	
                                        <li><a  onclick="loadDepartment()"><i class="icon-inbox"></i>员工管理</a></li>
                                        <li><a onclick="loadStaff()"><i class="icon-inbox"></i>员工调动信息</a></li>
                                           <li><a onclick="loadStaff()"><i class="icon-inbox"></i>部门管理</a></li>
                                    </ul>
                                </li>
                                
                            </ul>
                               <!-- 这里有一个 -->
                             <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#togglePages2"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>我的团队 </a><!-- 这里开始 -->
                                    <ul id="togglePages2" class="collapse unstyled">
                                        <li><a onclick="loadTeamTablePage()"><i class="icon-inbox"></i>团队管理 </a></li>
                                        <li><a onclick="loadTaskRelease()"><i class="icon-inbox"></i>发布任务 </a></li>
                                    </ul>
                                </li>
                                
                            </ul>
                            <!-- 这里有一个 -->
                             <ul class="widget widget-menu unstyled">
                                <li>
                                <a class="collapsed" data-toggle="collapse" href="#togglePages3">
                                <i class="menu-icon icon-cog">
                              </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>公告管理
                                 </a>
                                    <ul id="togglePages3" class="collapse unstyled">
                                        <li><a onclick="loadReleasePage()" id=""><i class="icon-inbox"></i>发布公告 </a></li>
                                        <li><a id="table" onclick="loadTablePage(id)"><i class="icon-inbox"></i>查看公告 </a></li>
                                      
                                    </ul>
                                </li>
                                
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                <div class="span9">
                
                <div id="content"></div>
                </div> 
                
                </div>
            </div>
            <!--/.container-->
        </div>
        
        <!--/.wrapper-->
        <div class="footer">
            <div  class="container"  align="center">
                <b class="copyright">&copy; 2017 L+X - PC9527 </b>All rights reserved. More Templates <a href="http://www.baidu.com/" target="_blank" title="PC9527">PC9527</a> 
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/common.js" type="text/javascript"></script>
      
    </body>
</body>
</html>