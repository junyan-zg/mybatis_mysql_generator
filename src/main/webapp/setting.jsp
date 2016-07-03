<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/include.jsp"%>
<script type="text/javascript">
function submitForm() {
	$('#myModal').modal('show')
	 $.ajax({
         type: "POST",
         url: "createFiles",
         data: $('#myForm').serialize(),
         timeout:0,
         cache:false,
         success: function(data){
        	 $('#myModal').modal('hide')
         },
         error:function(e){
        	alert(e);	 
         }
	 })
}	
</script>
</head>
<body>
	<div class="container">
		<div class="text-left col-sm-10">
			<h2 class="page-header">
				MyBatis之MySQL代码生成工具 <span class="pull-right alert alert-info"
					style="font-size: 16px; display: inline;">设置生成属性</span>
			</h2>
			<h3>
				<a href="index.jsp"><span class="btn-danger btn">当前数据库：${databasename}</span></a>
				<button class="btn btn-success" style="margin-left: 30px;"
					onclick="submitForm();"data-toggle="modal" data-target="#myModal" >一键生成</button>
			</h3>
		</div>
		<form class="form-horizontal" id="myForm">
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
			</div>
			<div class="row">
				<div class="form-group">
					<label class="col-sm-2 control-label">basepackage</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="basepackage"
							name="basepackage" placeholder="basepackage">
					</div>
					<label class="col-sm-1 control-label">module</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="module" name="module"
							placeholder="module">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">outRoot</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="outRoot"
							name="outRoot" placeholder="outRoot" value="${outRoot}">
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">提示</h4>
				</div>
				<div class="modal-body"><p class="text-primary text-center">正在生成中，请稍后……</p></div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

</body>
</html>