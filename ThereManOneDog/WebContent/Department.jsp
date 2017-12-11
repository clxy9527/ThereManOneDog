<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edmin</title>
        <link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="css/theme.css" rel="stylesheet">
        <link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
            <script>
		$(document).ready(function() {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
		} );
	</script>
    </head>
    <body>                     

     <div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">            
     							  <h3>部门管理</h3>                         
                                <div class="module-option clearfix">
                                    <div class="pull-left">
                                        <div class="btn-group">
                                            <button class="btn">
                                                全部</button>
                                      <!-- dropdown-toggle -->
                                           <button class="btn " data-toggle="dropdown">
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">公关部</a></li>
                                                <li><a href="#">财务部</a></li>
                                                <li><a href="#">行政部</a></li>
                                                <li><a href="#">技术部</a></li>
                                                <li class="divider"></li>
                                               
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="pull-right">
                                    <button class="btn btn-primary "  data-backdrop="static" data-toggle="modal" data-target="#myModal">添加员工</button>
                                       
                                    </div>
                                </div>
                                <div class="module-body table">
                                    <table class="table table-message">
                                        <tbody>
                                            <tr class="heading">
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                              		      姓名
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                          	          性别
                                                </td>
                                                  <td class="cell-author hidden-phone hidden-tablet">
                                          	         职位
                                                </td>
                                                  <td class="cell-author hidden-phone hidden-tablet">
                                          	          部门
                                                </td>
                                                <td class="cell-time align-right">
                                                   	入职日期
                                                </td>
                                            </tr>
                                            <tr >
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                   
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    John Donga
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    Sample Work
                                                </td>
                                                 <td class="cell-author hidden-phone hidden-tablet">
                                                    Test Title
                                                </td>
                                                 <td class="cell-author hidden-phone hidden-tablet">
                                                    Test Title
                                                </td>
                                                
                                                <td class="cell-time align-right">
                                                    18:24
                                                </td>
                                            </tr>
                                            <tr >
                                                <td class="cell-check">
                                                    <input type="checkbox" class="inbox-checkbox">
                                                </td>
                                                <td class="cell-icon">
                                                   
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    John Donga
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    Test Title
                                                </td>
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    Test Title
                                                </td> 
                                                <td class="cell-author hidden-phone hidden-tablet">
                                                    Test Title
                                                </td>
                                                <td class="cell-time align-right">
                                                    18:01
                                                </td>
                                            </tr>
                                           
                                        </tbody>
                                    </table>
                                </div>
                                <div class="module-foot">
                                </div>
                          </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->
       </div>
       
       
       <!-- 添加人员 -->
       <jsp:include page="/AddStaff.jsp" flush="true"/>
  


 <script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
    </html>