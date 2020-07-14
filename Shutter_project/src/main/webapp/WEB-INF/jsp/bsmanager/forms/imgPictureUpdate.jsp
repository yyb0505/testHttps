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
	<form id="imgPictureBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片编号：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="imgPictureBean.picNumber">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="imgPictureBean.picDescribe">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片大小：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="imgPictureBean.picSize">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片类型：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="imgPictureBean.picType">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片路径：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="imgPictureBean.picPath">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">所属组：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" v-model="imgPictureBean.groId">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="updatePicture()">确认更新</button>
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
		el: '#imgPictureBean',
		data: {
			imgPictureBean: null
		},
		created: function () {
			this.imgPictureBean = JSON.parse('${ip}');
		}
	});

	let layer;
	layui.use('layer', function() {
		 layer = layui.layer;
	});

	//更新
	function updatePicture(){
		$.ajax({
			url: "updateImgPicture",
			type: "post",
			dataType:"json",
			data:issb.imgPictureBean,
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