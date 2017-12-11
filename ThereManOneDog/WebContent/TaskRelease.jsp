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
                           
                           			<form style="vertical-align:middle;margin: 20px;">
                           			<table align="center" >
                           				<tbody>
                           					<tr style="border:0px;">
                           						<td>起始日期:</td>
                           						<td><input type="Date" name="startDate">为空为当前日期</td>
                           					</tr>
                           					<tr>
                           						<td>结束日期:</td>
                           						<td><input type="Date" name="endDate">为空则不结束</td>
                           					</tr>
                           					<tr>
                           						<td>任务内容:</td>
                           						<td>
                           							<textarea rows="" cols=""></textarea>
                           							<div style="color: red">此处不可空白</div>
                           						</td>
                           						
                           					</tr>
                           					<tr>
                           						<td>参与者:</td>
                           						<td><input type="text" readonly="readonly" name="taskMember"><a style="color: blue">+添加</a>   <a style="color: grey">清空</a></td>
                           					</tr>
                           					<tr>
                           						<td>任务提醒:</td>
                           						<td style="text-align: center;"><input type="checkbox" name="taskAlerm">发送任务提醒</td>
                           					</tr>
                           					<tr>
                           						<td >
                           							<button class="btn btn-primary" type="submit">确定</button>
                           							<button type="button">重置</button>
                           						</td>
                           					</tr>
                           				</tbody>
                           			</table>
                           		
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