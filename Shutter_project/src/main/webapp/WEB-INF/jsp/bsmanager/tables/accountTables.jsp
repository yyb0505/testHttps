<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>Tables - Azzara Bootstrap 4 Admin Dashboard</title>
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
				<a href="#">账号管理</a>
			</li>
			<li class="separator">
				<i class="flaticon-right-arrow"></i>
			</li>
			<li class="nav-item">
				<a href="#">管理员账号管理</a>
			</li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<table class="layui-hide" id="accountTable" lay-filter="test"></table>

					<script type="text/html" id="toolbarDemo">
						<div class="layui-btn-container">
							<button class="layui-btn layui-btn-sm" lay-event="addAccountPage">账户添加</button>
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

		table.render({
			elem: '#accountTable'
			,url:'queryAccountList'
			,toolbar: '#toolbarDemo'
			,totalRow: true
			,cols: [[
				{type: 'checkbox', fixed: 'left'}
				,{field:'id', title:'ID', width:80, fixed: 'left'}
				,{field:'accName', title:'账户名称'}
				,{field:'accPassword', title:'账户密码'}
				,{field:'accAuthority', title:'账户权限'}
				,{field:'accCreateDate', title:'创建时间'}
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
				case 'addAccountPage':
					layer.open({
						type: 2
						,title: '添加账户信息'
						,shade: 0.6
						,area: ['800px', '500px']
						,move:false
						,resize: false
						,maxmin: true
						,content: 'insertAccountPage'
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
						url: "deleteUsers",
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
					,title: '账户信息修改'
					,shade: 0.6
					,area: ['800px', '500px']
					,move:false
					,resize: false
					,maxmin: true
					,content: 'updateAccountPage?id='+data.id
				});
			}
		});
	});

	function reloadTable(){
		table.reload('accountTable', {
			url: 'queryAccountList'
			,where: {}
		});
	}

</script>
</body>
</html>