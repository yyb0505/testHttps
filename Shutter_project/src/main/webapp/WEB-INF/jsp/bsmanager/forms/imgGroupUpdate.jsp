<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>轮播图更新</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="imgGroupBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">组名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="imgGroupBean.groName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">组描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="imgGroupBean.groDescribe">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">类别id：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="imgGroupBean.catId">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="updateGroup()">确认更新</button>
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
		el: '#imgGroupBean',
		data: {
			imgGroupBean: null
		},
		created: function () {
			this.imgGroupBean = JSON.parse('${ig}');
		}
	});

	let layer;
	layui.use('layer', function() {
		 layer = layui.layer;
	});

	//更新
	function updateGroup(){
		$.ajax({
			url: "updateImgGroup",
			type: "post",
			dataType:"json",
			data:issb.imgGroupBean,
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