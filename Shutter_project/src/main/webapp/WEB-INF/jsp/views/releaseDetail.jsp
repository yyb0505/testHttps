<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Single</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Kids Video Game Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- css -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="../css/reset.css">
	<link rel="stylesheet" href="../css/slideShow.css">
	<link href="layui/css/layui.css" rel="stylesheet" type="text/css" media="all" />
	<style type="text/css">
		body{
			background-color: #eee;
		}
		body,h1,ul,h4,h5,dl,dd,p{
			margin: 0;
			padding: 0;
		}
		ul{
			list-style: none;
		}
		a{
			text-decoration: none;
		}

		/* 最新评论 */
		.panel{
			padding:20px;
			background-color: #ffffff;
			margin-top: 20px;
		}
		.panel .title{
			overflow: hidden;
		}
		.panel .title h4{
			font-size:20px;
			border-bottom: 2px solid #ff0000;
			float: left;
			line-height: 30px;
			font-weight: bold;
		}

		.discus>li{
			padding: 10px 0px;
			border-bottom: 1px solid #dddddd;
			overflow: hidden;
		}
		.discus li>ul>li{
			padding: 10px 0px;
			border-bottom: 1px solid #dddddd;
			overflow: hidden;
		}
		.discus li img{
			float: left;
			width: 40px;
			height: 40px;
			border-radius: 50%;
			transition: all 0.3s;
		}
		.discus li p{
			margin-left: 50px;
			font-size: 12px;
			color: #999999;
			margin-top: 4px;

		}
		.discus li p span{
			color: #444444;
			margin-right: 5px;
		}
		.discus li:hover{
			background-color: #f8fcfc;

		}
		.discus li:hover img{
			transform: rotate(360deg) scale(1.1);
		}

		.wthree_blog_left .wthree_blog_left_grid_slider{
			overflow: hidden;
		}
		.wthree_blog_left .wthree_blog_left_grid_slider img{
			float: left;
			max-width: 100%;
		}


		.commentbox{
			width: 900px;
			margin: 20px auto;
		}
		.mytextarea {
			width: 100%;
			overflow: auto;
			word-break: break-all;
			height: 100px;
			color: #000;
			font-size: 1em;
			resize: none;
		}
		.comment-list{
			width: 900px;
			margin: 20px auto;
			clear: both;
			padding-top: 20px;
		}
		.comment-list .comment-info{
			position: relative;
			border-bottom: 1px solid #ccc;
		}
		.comment-list .comment-info header{
			width: 10%;
			position: absolute;
		}
		.comment-list .comment-info header img{
			width: 100%;
			border-radius: 50%;
			padding: 5px;
		}
		.comment-list .comment-info .comment-right{
			padding:5px 0px 5px 11%;
		}
		.comment-list .comment-info .comment-right h5{
			margin: 5px 0px;
			text-align: left;
		}
		.comment-list .comment-info .comment-right .comment-content-header{
			height: 25px;
		}
		.comment-list .comment-info .comment-right .comment-content-header span,.comment-list .comment-info .comment-right .comment-content-footer span{
			padding-right: 2em;
			color: #aaa;
		}
		.comment-list .comment-info .comment-right .comment-content-header span,.comment-list .comment-info .comment-right .comment-content-footer span.reply-btn,.send,.reply-list-btn{
			cursor: pointer;
		}
		.comment-list .comment-info .comment-right .reply-list {
			border-left: 3px solid #ccc;
			padding-left: 7px;
		}
		.comment-list .comment-info .comment-right .reply-list .reply{
			border-bottom: 1px dashed #ccc;
		}
		.comment-list .comment-info .comment-right .reply-list .reply div span{
			padding-left: 10px;
		}
		.comment-list .comment-info .comment-right .reply-list .reply p span{
			padding-right: 2em;
			color: #aaa;
		}
		.comId{
			display: none;
		}
	</style>
	<!--// css -->
	<!-- font -->
	<link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<!-- //font -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script src="../js/vue.min.js"></script>
	<script src="../layui/layui.js"></script>
	<script src="../js/jquery.comment.js"></script>
</head>
<body>
<!-- banner -->
<div class="sub-banner">
	<!-- Navbar -->
	<jsp:include page="/WEB-INF/jsp/views/common/headerComm.jsp"></jsp:include>
</div>
<!-- banner -->

<!-- single -->
<div class="blog" id="releaseDetail">
	<div class="container">
		<div class="col-md-12 wthree_blog_left">
			<div class="wthree_blog_left_grid">
				<div class="wthree_blog_left_grid_slider">
					<div>
						<div class="box">
							<!--<button @click="imgMove">点击</button>-->
							<div class="main clearfix" @mouseover="btnOpen" @mouseout="btnHide">
								<div class="minMain">
									<div class="item" v-for="(item,index) in list" :key="index">
										<img :src="item.imgUrl" />
									</div>
								</div>
								<div class="btnMain" v-show="btnShow">
									<div class="left" @click="leftClick">
										<img src="../images/views/ljiantou.png" />
									</div>
									<div class="right" @click="rightClick">
										<img src="../images/views/rjiantou.png" />
									</div>
								</div>
								<div class="pressMain">
									<span v-for="(item,index) in pressList" :class="{active:item.isShow}"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h4>{{commRelease.relTitle}}</h4>
				<h3>可惜在遇见我那天你并不快乐,可能是因为我们相遇的太晚了。</h3>
				<ul>
					<li><span class="glyphicon glyphicon-user" aria-hidden="true"></span><a href="#">{{commRelease.userId}}</a><i>|</i></li>
					<li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span><a href="#">999+</a><i>|</i></li>
					<li><span class="glyphicon glyphicon-tag" aria-hidden="true"></span><a href="#">168</a><i>|</i></li>
					<li><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>{{commRelease.relPageView}}</li>
				</ul>
				<p>
					{{commRelease.relDescribe}}
					<%--<i>可惜在遇见我那天你并不快乐，可能是因为我们相遇的太晚了。</i>
					<i>可是我要走了，可温暖要走了，可否有另一个我在你身后给予快乐。</i>
					<i>可当我牵着你的手傻乎乎的乐，渴望的爱情终于在我生命出现了。</i>
					<i>可时间倒数了，可你的答案停住了，可想到你的脸我还是很快乐。</i>--%>
				</p>
			</div>
			<!-- <div class="agileits_share">
                <ul>
                    <li><a class="linkedin" href="#"></a></li>
                    <li><a class="google" href="#"></a></li>
                    <li><a class="twitter" href="#"></a></li>
                    <li><a class="facebook" href="#"></a></li>
                </ul>
            </div> -->

			<%--<div class="agileits_reply">
				<h3>发表评论</h3>
				<form action="#" method="post">
					<!-- <input type="text" name="Name" placeholder="Name" required="">
                    <input type="email" name="Email" placeholder="Email" required="">
                    <input type="text" name="Subject" placeholder="Subject" required=""> -->
					<textarea name="comContent"  id="comContent" placeholder="写点什么..." required=""></textarea>
					<input type="button" onclick="commitComment()" value="提交">
				</form>
			</div>--%>

			<div class="panel discus">
				<div class="title">
					<h4>最新评论</h4>
				</div>

				<div class="commentbox">
					<h3>发表评论</h3>
					<textarea cols="80" rows="50" placeholder="来说几句吧......" class="mytextarea" id="content"></textarea>
					<div class="btn btn-info pull-right" id="comment" onclick="commitComment()">评论</div>
				</div>
				<div class="comment-list">

				</div>
				<%--<ul>
					<li v-for="(comment,index) in commentList">
						<a href="javascript:;">
							<img src="../images/views/avater_1.jpg" alt="">
							<p><span>{{comment.userId}}</span> {{comment.comCreateDate}} </p>
							<p>{{comment.comContent}}</p>
						</a>
					</li>

					<li>
						<a href="javascript:;">
							<img src="../images/views/avater_2.jpg" alt="">
							<p><span>一点点的蓝</span> 2020-05-01 </p>
							<p>挺会玩的</p>
						</a>
					</li>

					<li>
						<a href="javascript:;">
							<img src="../images/views/avater_3.jpg" alt="">
							<p><span>爱如玫瑰</span> 2020-04-29 </p>
							<p>花里胡哨</p>
						</a>
					</li>

					<li>
						<a href="javascript:;">
							<img src="../images/views/avater_4.jpg" alt="">
							<p><span>深蓝</span> 2020-04-17 </p>
							<p>真棒，继续加油！</p>
						</a>
					</li>

					<li>
						<a href="javascript:;">
							<img src="../images/views/avater_5.jpg" alt="">
							<p><span>回忆</span>  2020-04-02 </p>
							<p>666</p>
						</a>
					</li>

					<li>
						<a href="javascript:;">
							<img src="../images/views/avater_6.jpg" alt="">
							<p><span>鲜活</span> 2020-03-15 </p>
							<p>不错嘛</p>
						</a>
					</li>
				</ul>--%>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!-- //single -->

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/views/common/footer.jsp"></jsp:include>
<!-- //footer -->
<script src="../../js/vue.min.js"></script>
<script>

	let releaseDetail = new Vue({
		el: '#releaseDetail',
		data: {
			userInfo:null,
			commRelease: null,
			cpList:null,
			commentList:null,
			list: [],
			pressList: [],
			numList: [],
			imgIndex: 0,
			imgTimer: null,
			btnShow: false,
			picNumber:0
		},
		created: function () {
			this.commRelease = JSON.parse('${cr}');
			this.cpList = JSON.parse('${cpList}');
			this.commentList = JSON.parse('${commentList}');
			//$(".comment-list").addCommentList({data:this.commentList,add:""});

			console.log("commentList:"+'${commentList}');
			console.log("commRelease:"+'${cr}');
			console.log("cpList:"+'${cpList}');
			for(let i in this.cpList){
				let img = {imgUrl:this.cpList[i].picPath};
				this.list.push(img);
				this.numList.push("p"+i);
				this.pressList.push({ name: i+1, isShow: false });
			}
			this.picNumber = this.numList.length;
			//alert(${userInfo});

		},
		mounted: function() {
			let Item = document.getElementsByClassName('item');
			for(let i = 0; i < Item.length; i++) {
				Item[i].className = 'item ' + this.numList[i]
			}
			this.pressList[0].isShow = true
		},
		methods: {
			imgMove() {
				let Item = document.getElementsByClassName('item');
				this.imgTimer = setInterval(() => {
					this.numList.push(this.numList[0]);
					this.numList.shift()
					this.imgIndex++;
					for(let i = 0; i < Item.length; i++) {
						Item[i].className = 'item ' + this.numList[i];
					}
					for(var i in this.pressList) {
						this.pressList[i].isShow = false
					}
					if(this.imgIndex > this.picNumber-1) {
						this.imgIndex = 0
						this.pressList[this.imgIndex].isShow = true;
					} else {
						this.pressList[this.imgIndex].isShow = true;
					}
				}, 15000)
			},
			btnOpen() {
				this.btnShow = true;
				clearInterval(this.imgTimer)
			},
			btnHide() {
				this.btnShow = false;
				this.imgMove()
			},
			leftClick() {
				var Item = document.getElementsByClassName('item');
				this.numList.unshift(this.numList[this.picNumber-1]);
				this.numList.pop()
				for(var i = 0; i < Item.length; i++) {
					Item[i].className = 'item ' + this.numList[i];
				}
				for(var i in this.pressList) {
					this.pressList[i].isShow = false
				}
				this.imgIndex--
				if(this.imgIndex < 0) {
					this.imgIndex = this.picNumber-1;
					this.pressList[this.imgIndex].isShow = true;
				} else {
					this.pressList[this.imgIndex].isShow = true;
				}
			},
			rightClick() {
				var Item = document.getElementsByClassName('item');
				this.numList.push(this.numList[0]);
				this.numList.shift()
				for(var i = 0; i < Item.length; i++) {
					Item[i].className = 'item ' + this.numList[i];
				}
				for(var i in this.pressList) {
					this.pressList[i].isShow = false
				}
				this.imgIndex++
				if(this.imgIndex > this.picNumber-1) {
					this.imgIndex = 0
					this.pressList[this.imgIndex].isShow = true;
				} else {
					this.pressList[this.imgIndex].isShow = true;
				}
			}
		}
	});

	//提交评论
	function commitComment(){

		if(userInfo == "" || userInfo == null){
			alertContent("您还未登录，请登录！");
		}else{
			console.log("relId:"+releaseDetail.commRelease.id);
			let content = $("#content").val();
			console.log("content:"+content);
			console.log("userId:"+userInfo.userId);
			if(content == ""){
				alert("评论不能为空！");
			}else{
				let dataObj = {relId:releaseDetail.commRelease.id,comContent:content,userId:userInfo.userId};
				insertComment(dataObj);
			}

		}
	}

	function insertComment(dataObj){
		$.ajax({
			url: "insertComment",
			type: "post",
			dataType:"json",
			data:dataObj,
			success: function(data){
				if(data.code == 0){
					$("#content").val("");									//将评论置空
					$(".comment-list").html("");
					$(".comment-list").addCommentList({data:JSON.parse(data.data),add:""});
					//releaseDetail.commentList = JSON.parse(data.data);		//刷新评论数据

				}else{
					alert("error");
				}
			}
		});
	}


	function alertContent(msg){
		alert(msg);
	}

	$(function(){
		$(".comment-list").addCommentList({data:releaseDetail.commentList,add:""});
	})

</script>
</body>
</html>