<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>动态更新</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="commReleaseBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">动态标题：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="commReleaseBean.relTitle">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">动态描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="commReleaseBean.relDescribe">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">动态访问量：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="commReleaseBean.relPageView">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="commReleaseBean.userId">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">所属类别：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="commReleaseBean.catId">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="updateRelease()">确认更新</button>
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
		el: '#commReleaseBean',
		data: {
			commReleaseBean: null
		},
		created: function () {
			this.commReleaseBean = JSON.parse('${ic}');
		}
	});

	let layer;
	layui.use('layer', function() {
		 layer = layui.layer;
	});

	//更新
	function updateRelease(){
		$.ajax({
			url: "updateCommRelease",
			type: "post",
			dataType:"json",
			data:issb.commReleaseBean,
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