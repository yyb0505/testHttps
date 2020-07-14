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
	<form id="imgSlideShowBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">轮播图名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="imgSlideShowBean.sliName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">轮播图描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="imgSlideShowBean.sliDescribe">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">轮播图路径：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" v-model="imgSlideShowBean.sliPath">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">轮播图状态：</label>
			<div class="col-md-10 col-sm-10">
				<select name=""  class="form-control" v-model="imgSlideShowBean.sliStatus">
					<option value="1">在用</option>
					<option value="0">未用</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="updateSlideShow()">确认更新</button>
			</div>
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-info center-block" type="button" onclick="cancelUpdate()">取消</button>
			</div>
		</div>

	</form>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/vue.min.js"></script>
<script src="../../layui/layui.js" charset="utf-8"></script>
<script>
	let issb = new Vue({
		el: '#imgSlideShowBean',
		data: {
			imgSlideShowBean: null
		},
		created: function () {
			this.imgSlideShowBean = JSON.parse('${issb}');
		}
	});

	let layer;
	layui.use('layer', function() {
		 layer = layui.layer;
	});

	//更新
	function updateSlideShow(){
		$.ajax({
			url: "updateImgSlideShow",
			type: "post",
			dataType:"json",
			data:issb.imgSlideShowBean,
			success: function(data){
				if(data.code == 200){
					//layer.msg(data.msg,{icon: 6});
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.reloadTable();
					parent.layer.close(index);
				}else{
					layer.msg(data.msg,{icon: 5});
				}
			}
		});
	}

	//取消更新
	function cancelUpdate(){

	}


</script>
</body>
</html>