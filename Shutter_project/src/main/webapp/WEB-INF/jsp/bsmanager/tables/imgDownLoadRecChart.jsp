<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>Tables - Azzara Bootstrap 4 Admin Dashboard</title>
	<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
	<link rel="icon" href="../../assets/img/icon.ico" type="image/x-icon"/>
	<!-- Fonts and icons -->
	<script src="../../assets/js/plugin/webfont/webfont.min.js"></script>
	<script src="../../js/jquery.min.js"></script>
	<script src="../../echarts/echarts.min.js"></script>
	<script>
		WebFont.load({
			google: {"families":["Open+Sans:300,400,600,700"]},
			custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands"], urls: ['../assets/css/fonts.css']},
			active: function() {
				sessionStorage.fonts = true;
			}
		});
	</script>
	<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../assets/css/azzara.min.css">
	<link rel="stylesheet" href="../../assets/css/demo.css">
	<link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>
<div class="page-inner">
	<div class="page-header">
		<ul class="breadcrumbs">
			<li class="nav-home">
				<a href="#">
					<i class="flaticon-home"></i>
				</a>
			</li>
			<li class="separator">
				<i class="flaticon-right-arrow"></i>
			</li>
			<li class="nav-item">
				<a href="#">统计报表</a>
			</li>
			<li class="separator">
				<i class="flaticon-right-arrow"></i>
			</li>
			<li class="nav-item">
				<a href="#">近期图片下载趋势图</a>
			</li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">用户名：</label>
							<div class="layui-input-inline">
								<input type="text" name="userName" id="userName" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<button type="button" class="layui-btn layui-btn-normal" onclick="queryRecord()">查询</button>
						</div>
						</div>
					<div id="imgDownLoadRec" style="width: 1200px;height:400px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

	let queryData = null;

	$.ajax({
		url: "queryImgDownLoadRec",
		type: "post",
		dataType:"json",
		data:{num:12},
		success: function(data){
			renderCharts(data);
			queryData = data;
		}
	});

	function queryRecord(){
		let userName = $("#userName").val().trim();
		if(userName != ''){
			$.ajax({
				url: "queryImgDownLoadRecByName",
				type: "post",
				dataType:"json",
				data:{num:12,userName:userName},
				success: function(data){
					console.log(JSON.stringify(data));
					renderCharts(data);
				}
			});
		}else{
			renderCharts(queryData);
		}
	}

	function renderCharts(obj){
		var myChart = echarts.init(document.getElementById('imgDownLoadRec'));
		var option = {
			title: {
				text: obj.userName,
				left: 'center'
			},
			xAxis: {
				type: 'category',
				boundaryGap: false,
				data: obj.keys
			},
			yAxis: {
				type: 'value'
			},
			series: [{
				data: obj.values,
				type: 'line',
				areaStyle: {}
			}]
		};

		myChart.setOption(option);
	}

</script>
</body>
</html>