<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="scripts/jquery-1.9.1.min.js"></script>
	<script src="scripts/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="scripts/datatables/jquery.dataTables.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="css/theme.css" rel="stylesheet">
	<link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>

</head>
<body>

					<div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">
                                    <h3>新建任务清单</h3>
                                </div>
                                <div class="module-body table">
                           
                           			<form style="vertical-align:middle">
                           			起始日期:<input type="Date" name="startDate"> 为空为当前日期<br>
                           			结束日期:<input type="Date" name="endDate">  为空则不结束<br>
                           			任务内容:<input type="text" name="taskContent"><h3 style="color: red">此处不可空白</h3><br>
                           			参与者:<input type="text" readonly="readonly" name="taskMember"><a style="color: blue">+添加</a>   <a style="color: grey">清空</a><br>
                           			任务提醒:<input type="checkbox" name="taskAlerm">发送任务提醒
                           			<a class="btn btn-primary">确定</a>
                           			</form>
                                    </div>
                                </div>
                             
                            </div>
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->				
</body>
</html>