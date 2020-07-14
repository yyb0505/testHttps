<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>账户信息更新</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="accountBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">账户名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="bsAccount.accName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">账户密码：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="bsAccount.accPassword">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">账户权限：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="bsAccount.accAuthority">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="updateAccount()">确认更新</button>
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
			bsAccount: null
		},
		created: function () {
			this.bsAccount = JSON.parse('${ba}');
		}
	});

	let layer;
	layui.use('layer', function() {
		 layer = layui.layer;
	});

	//更新
	function updateAccount(){
		$.ajax({
			url: "updateAccount",
			type: "post",
			dataType:"json",
			data:issb.bsAccount,
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