<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>图片添加</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="imgPictureBean"  action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片路径：</label>
			<div class="col-md-10 col-sm-10">
				<input type="file" name="file" /><br/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">图片描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="picDescribe" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">组名称</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="groId">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="addImgPicture()">添加</button>
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
	function addImgPicture(){
		let formData = $("#imgPictureBean")[0];
		let issb = new FormData(formData);
		$.ajax({
			url: "addImgPicture",
			type: "post",
			async: false,
			cache: false,
			contentType: false,
			processData: false,
			dataType:"json",
			data:issb,
			success: function(data){
				if(data.code == 200){
					//layer.msg(data.msg,{icon: 6});
					var index = parent.layer.getFrameIndex(window.name);
					parent.reloadTable();
					parent.layer.close(index);
				}else{
					alert(data.msg);
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