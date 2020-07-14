<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>图片类别添加</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="imgCategoryBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">类别名称：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="catName" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">类别描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="catDescribe">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">类别图片路径：</label>
			<div class="col-md-10 col-sm-10">
				<input type="email" class="form-control" name="catImgPath">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">类别状态：</label>
			<div class="col-md-10 col-sm-10">
				<select name="catType"  class="form-control" >
					<option value="1">热门</option>
					<option value="0">普通</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="addImgCategory()">添加</button>
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
	function addImgCategory(){
		let issb = $("#imgCategoryBean").serialize();
		$.ajax({
			url: "addImgCategory",
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