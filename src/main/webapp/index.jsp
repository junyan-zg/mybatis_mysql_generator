<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/include.jsp"%>
</head>
<body>
	<div class="container">
	<div class="text-center col-sm-9">
		<h1 class="page-header">MyBatis之MySQL代码生成工具</h1></div>
		<form class="form-horizontal" action="enterDatabase" method="post">
			<!--form-inline-->
			<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">IP地址</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="ip" name="ip"
						placeholder="IP地址" value="localhost:3306">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">数据库名称</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="databasename"
						name="databasename" placeholder="数据库名称" value="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">数据库用户名</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="username"
						name="username" placeholder="数据库用户名" value="root">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">数据库密码</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="数据库密码" value="1234">
				</div>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label"></label>
				<div class="col-sm-7">
					<button class="btn btn-primary pull-right">连接数据库</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>