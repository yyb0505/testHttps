<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>动态类别添加</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
<div class="container">
	<form id="commReleaseBean" action="" class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">动态标题：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="relTitle" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">动态描述：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="relDescribe">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">动态访问量：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="relPageView">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">用户：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="userId">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 col-sm-2 control-label">所属类别：</label>
			<div class="col-md-10 col-sm-10">
				<input type="text" class="form-control" name="catId">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6">
				<button class="btn btn-success center-block" type="button" onclick="addCommRelease()">添加</button>
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
	function addCommRelease(){
		let issb = $("#commReleaseBean").serialize();
		$.ajax({
			url: "addCommRelease",
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