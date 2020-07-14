<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="renderer" content="webkit">
	<title>Shutter登录</title>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
	<div >
		<div class="container">
			<div class="title_logo">
				<h2 class="text-center"><b>Shutter</b></h2>
			</div>
			<!--界面选项卡-->
			<div class="row">
				<div class="col-md-4 col-xs-1"></div>
				<div class="col-md-4 col-xs-10">
					<div class="row">
						<div class="col-md-6 col-xs-6"><p class="text-center tab tab_login tab_this" onclick="changeTag('login')">登录</p></div>
						<div class="col-md-6 col-xs-6"><p class="text-center tab tab_register"  onclick="changeTag('register')">注册</p></div>
					</div>
				</div>
				<div class="col-md-4 col-xs-1"></div>
			</div>
			<!--登录界面-->
			<div class="div_login">
				<form action="" method="post" id="userForm" class="form-horizontal" name="form_login">
					<div class="row">
					  <div class="col-md-4 col-xs-1" ></div>
					  <div class="col-md-4 col-xs-10">
					    <div class="input-group">
					      <span class="input-group-addon glyphicon glyphicon-user "></span>
					      <input type="text" class="form-control input-lg" name="name" aria-label="username" placeholder="用户名">
					    </div>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
					    <div class="input-group">
					      <span class="input-group-addon glyphicon glyphicon-lock"></span>
					      <input type="password" class="form-control input-lg" name="pwd" aria-label="password" placeholder="密码">
					    </div>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
					      <button class="btn btn-info btn-block btn-lg" type="button" onclick="userLogin()">登录</button>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					<div class="row">
					<div class="col-md-4 col-xs-1"></div>
					<div class="col-md-4 col-xs-10">
						<p>
							<a href="#" class="forget_password">忘记密码</a>
							<a href="#" class="to_register">没有账号？去注册</a>
						</p>
					</div>
					<div class="col-md-4 col-xs-1"></div>
				</div>
				</form>
			</div>
			
			<!--注册界面-->
			<div class="div_register" style="display: none;">
				<form action="" class="form-horizontal" name="form_register">
					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
					    <div class="input-group">
					      <span class="input-group-addon glyphicon glyphicon-user"></span>
					      <input type="text" class="form-control input-lg" aria-label="username" placeholder="用户名">
					    </div>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
					    <div class="input-group">
					      <span class="input-group-addon glyphicon glyphicon-lock"></span>
					      <input type="password" class="form-control input-lg" aria-label="password" placeholder="密码">
					    </div>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					
					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
					    <div class="input-group">
					      <span class="input-group-addon glyphicon glyphicon-phone"></span>
					      <input type="text" class="form-control input-lg" aria-label="phone" placeholder="手机号">
					    </div>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>

					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
						<div class="input-group">
						    <span class="input-group-addon glyphicon glyphicon-list-alt"></span>
						    <input type="text" class="form-control input-lg" aria-label="phone" placeholder="验证码">
						    <span class="input-group-addon phone_code" onclick="phoneCode()">获取验证码</span>
						</div>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					<div class="row">
					  <div class="col-md-4 col-xs-1"></div>
					  <div class="col-md-4 col-xs-10">
					      <button class="btn btn-info btn-block btn-lg" type="submit">注册</button>
					  </div>
					  <div class="col-md-4 col-xs-1"></div>
					</div>
					<div class="row">
					<div class="col-md-4 col-xs-1"></div>
					<div class="col-md-4 col-xs-10">
						<p>
							<a href="#" class=""></a>
							<a href="#" class="to_login">已有账号？去登录</a>
						</p>
					</div>
					<div class="col-md-4 col-xs-1"></div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript">
		function changeTag(tab){
			if(tab === 'login'){
				$(".tab_login").addClass('tab_this');
				$(".tab_register").removeClass('tab_this');
				$(".div_login").show();	
				$(".div_register").hide();
			}else if(tab === 'register'){
				$(".tab_register").addClass('tab_this');
				$(".tab_login").removeClass('tab_this');
				$(".div_login").hide();
				$(".div_register").show();	
			}
		}

		function userLogin(){
			let userForm = $("#userForm").serialize();
			$.ajax({
				url: "userLogin",
				type: "post",
				dataType:"json",
				data:userForm,
				success: function(data){
					if(data.code == 200){
						window.location.href="index";
					}else{
						alert(data.msg);
					}
				}
			});

		}

		function phoneCode(){
			alert("验证码已发送！");
		}
	</script>
</body>
</html>