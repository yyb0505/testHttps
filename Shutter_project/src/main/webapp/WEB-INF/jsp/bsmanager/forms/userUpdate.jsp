<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户信息更新</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="accountBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="user.userName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户密码：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="user.userPwd">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">性别：</label>
			<div class="col-md-10 col-sm-10">
				<select v-model="user.userSex" class="form-control">
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">手机：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="user.userPhone">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户头像：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="user.userProfile">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户级别：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="user.userLevel">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">状态：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="user.userStatus">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="updateUser()">确认更新</button>
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
	let issb = new Vue({
		el: '#accountBean',
		data: {
			user: null
		},
		created: function () {
			this.user = JSON.parse('${user}');
		}
	});

	let layer;
	layui.use('layer', function() {
		 layer = layui.layer;
	});

	//更新
	function updateUser(){
		$.ajax({
			url: "updateUsers",
			type: "post",
			dataType:"json",
			data:issb.user,
			success: function(data){
				if(data.code == 200){
					//layer.msg(data.msg,{icon: 6});
					let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
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
		let index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}


</script>
</body>
</html>