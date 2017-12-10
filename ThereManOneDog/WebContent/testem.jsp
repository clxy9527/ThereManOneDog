<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ThereManOneDog</title>
        <link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="css/theme.css" rel="stylesheet">
        <link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
        <link type="text/css" href="">
<script type="text/javascript" src="scripts/ajax.js"></script>
<script type="text/javascript" src="scripts/datatable.js"></script>
<script charset="utf-8" src="./kindeditor-4.1.7/jquery.js"></script>
 <script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="scripts/common.js" type="text/javascript"></script>
      
</head>
<body>
<table>
<tr>
<td>
                <div class="col-md-6">         
                    <ul class="nav nav-pills nav-stacked">
                        <!--  <c:forEach items="${sessionScope.dept_list}" var="dept" varStatus="no">
                            <li>
                            <a  data-toggle="tab" onclick="get_employee_list('${no.index}')">${dept.getD_name()}</a>
                            </li>
                        </c:forEach> -->
                        <li><a  data-toggle="tab">部门A</a></li>
                        <li><a  data-toggle="tab">部门A</a></li>
                        <li><a  data-toggle="tab">部门A</a></li>
                    </ul>
                </div>
                </td>
                <td>
               
                
                <div id="eployee_list" class="col-md-6">
                <ul>
                    <li>你好</li>
                    <li>测试</li>
                </ul>
                </div>
                 </td>
                </tr>
                </table>
</body>
</html>