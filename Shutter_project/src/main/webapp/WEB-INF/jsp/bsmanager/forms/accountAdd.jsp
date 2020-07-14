<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>管理员账户添加</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="accountBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">账户名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="accName" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">账户密码：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="accPassword">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">账户权限：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="accAuthority">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="addAccount()">添加</button>
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
	function addAccount(){
		let issb = $("#accountBean").serialize();
		$.ajax({
			url: "insertAccount",
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