<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>动态类别信息表格</title>
	<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
	<link rel="stylesheet" href="../../layui/css/layui.css"  media="all">
	<link rel="icon" href="../../assets/img/icon.ico" type="image/x-icon"/>
	<!-- Fonts and icons -->
	<script src="../../assets/js/plugin/webfont/webfont.min.js"></script>
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
				<a href="#">数据管理</a>
			</li>
			<li class="separator">
				<i class="flaticon-right-arrow"></i>
			</li>
			<li class="nav-item">
				<a href="#">动态类别管理</a>
			</li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<table class="layui-hide" id="commCategory" lay-filter="test"></table>

					<script type="text/html" id="toolbarDemo">
						<div class="layui-btn-container">
							<button class="layui-btn layui-btn-sm" lay-event="addCommCategoryPage">动态类别添加</button>
							<%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
							<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>--%>
						</div>
					</script>
					<script type="text/html" id="barDemo">
						<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
						<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
					</script>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../layui/layui.js" charset="utf-8"></script>
<script>
	let table;
	layui.use('table', function(){
		 table = layui.table;

		//温馨提示：默认由前端自动合计当前行数据。从 layui 2.5.6 开始： 若接口直接返回了合计行数据，则优先读取接口合计行数据。
		//详见：https://www.layui.com/doc/modules/table.html#totalRow
		table.render({
			elem: '#commCategory'
			,url:'queryCommCategoryList'
			,toolbar: '#toolbarDemo'
			,totalRow: true
			,cols: [[
				{type: 'checkbox', fixed: 'left'}
				,{field:'id', title:'ID', width:80, fixed: 'left'}
				,{field:'cateName', title:'类别名称'}
				,{field:'cateDescribe', title:'类别描述'}
				,{field:'cateCreateDate', title:'创建时间'}
				,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
			]]
			,page: true
			,request: {
				pageName: 'page'
				,limitName: 'pageSize'
			}
		});

		//工具栏事件
		table.on('toolbar(test)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
			switch(obj.event){
				case 'addCommCategoryPage':
					layer.open({
						type: 2
						,title: '添加图片类别信息'
						,shade: 0.6
						,area: ['800px', '500px']
						,move:false
						,resize: false
						,maxmin: true
						,content: 'commCategoryAdd'
					});
				break;
			}
		});

		//监听行工具事件
		table.on('tool(test)', function(obj){
			let data = obj.data;
			if(obj.event === 'del'){
				layer.confirm('真的删除行么', function(index){
					$.ajax({
						url: "deleteCommCategory",
						type: "post",
						dataType:"json",
						data:{id:data.id},
						success: function(data){
							if(data.code == 200){
								obj.del();
								layer.close(index);
								reloadTable();
							}else{
								layer.msg(data.msg,{icon: 5});
							}
						}
					});

				});
			} else if(obj.event === 'edit'){
				layer.open({
					type: 2
					,title: '图片类别信息修改'
					,shade: 0.6
					,area: ['800px', '500px']
					,move:false
					,resize: false
					,maxmin: true
					,content: 'commCategoryUpdate?id='+data.id
				});
			}
		});


	});

	function reloadTable(){
		table.reload('commCategory', {
			url: 'queryCommCategoryList'
			,where: {}
		});
	}

</script>
</body>
</html>