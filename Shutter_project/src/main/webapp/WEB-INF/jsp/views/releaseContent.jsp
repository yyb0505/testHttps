<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>动态发表</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Kids Video Game Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- css -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="layui/css/layui.css" rel="stylesheet" type="text/css" media="all" />
	<style>
		.layui-upload-img{width: 23%; margin: 10px 1%;}
	</style>
	<!--// css -->
	<!-- font -->
	<link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<!-- //font -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script src="../js/vue.min.js"></script>
	<script src="layui/layui.js"></script>
</head>
<body>
<!-- banner -->
<div class="sub-banner">
	<!-- Navbar -->
	<jsp:include page="/WEB-INF/jsp/views/common/headerComm.jsp"></jsp:include>
</div>
<!-- banner -->

<!-- single -->
<div class="blog">
	<div class="container">

		<div class="layui-upload">
			<button type="button" class="layui-btn" id="test2">图片上传</button>
			<blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
				预览图：
				<div class="layui-upload-list" id="demo2"></div>
			</blockquote>
		</div>

		<form action="" id="releaseForm" class="form-horizontal">
			<div class="form-group">
				<label for="" class="col-md-1 control-label">标题:</label>
				<div class="col-md-11">
					<input type="text" name="relTitle" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label for="" class="col-md-1 control-label">描述:</label>
				<div class="col-md-11">
					<textarea class="form-control" name="relDescribe" rows="5"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="" class="col-md-1 control-label">类别:</label>
				<div class="col-md-11">
					<select name="catId"  class="form-control">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
			</div>
			<button type="button" class="btn btn-default" onclick="sumbitRelease()">提交</button>
		</form>
	</div>
</div>
<!-- //single -->

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/views/common/footer.jsp"></jsp:include>
<!-- //footer -->
<script>
	let imgList = [];
	layui.use('upload', function(){
		var upload = layui.upload;

		//多图片上传
		upload.render({
			elem: '#test2'
			,url: 'upload/upload' //改成您自己的上传接口
			,multiple: true
			,before: function(obj){
				obj.preview(function(index, file, result){
					$('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
				});
			}
			,done: function(res){
				//console.log(JSON.stringify(res));
				if(res.code == 0){
					imgList.push(res.data);
				}else{
					alert("图片上传失败！");
				}
				//console.log(JSON.stringify(imgList));
			}
			,error: function(index, upload){
				alert("接口异常！");
			}
		});

	});

	function sumbitRelease (){
		if(userInfo == "" || userInfo == null){
			alert("您还未登录，请登录！");
		}else{
			if(imgList.length != 0){
				let fromData = $("#releaseForm").serialize() + "&userId=" + userInfo.userId + "" + "&imgList=" + JSON.stringify(imgList);
				$.ajax({
					url: "releaseContent",
					type: "post",
					dataType:"json",
					data:fromData,
					success: function(data){
						if(data.code == 200){
							alert(data.msg);
							window.location.href = "communityPage";
						}else{
							alert(data.msg);
						}
					}
				});
			}else{
				alert("图片不能为空！");
			}
		}
	}
</script>
</body>
</html>