<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户添加</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="userBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="userName" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户密码：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="userPwd">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">性别：</label>
			<div class="col-md-10 col-sm-10">
				<select name="userSex" class="form-control">
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">手机号：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="userPhone">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户头像：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="userProfile">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户级别：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="userLevel">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="addUser()">添加</button>
			</div>
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-info center-block" type="button" onclick="cancelOperate()">取消</button>
			</div>
		</div>

	</form>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/vue.min.js"></script>
<script src="../../layui/layui.js" charset="utf-8"></script>
<script>
	//添加
	function addUser(){
		let issb = $("#userBean").serialize();
		$.ajax({
			url: "insertUsers",
			type: "post",
			dataType:"json",
			data:issb,
			success: function(data){
				if(data.code == 200){
					//layer.msg(data.msg,{icon: 6});
					var index = parent.layer.getFrameIndex(window.name);
					parent.reloadTable();
					parent.layer.close(index);
				}else{
					layer.msg(data.msg,{icon: 5});
				}
			}
		});
	}

	//取消更新
	function cancelOperate(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}


</script>
</body>
</html>