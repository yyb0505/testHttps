<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>类别组列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Kids Video Game Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
	<link href="../css/popup-box.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
	<style type="text/css">

		.info {
			width:100%;
			height: 100%;
			position: absolute;
			top: 0;
			left: 0;
			opacity: 0;
			color: #fff;
			transition: opacity 0.2s ease-out, background 0.2s ease-out;
			z-index: 1;
		}

		.item:hover .info {
			opacity: 1;
			border: 1px solid #000;
		}

		.image-ops {
			position: absolute;
			bottom: 2px;
			left: 0;
			width: 100%;
			height: 28px;
			text-align: right;
			font-size: 0;
		}


		.image-ops span {
			display: inline-block;
			width: 36px;
			height: 28px;
			padding: 5px 0;
			margin-right: 5px;
			font-size: 12px;
			color: #fff;
			opacity: 0.6;
			background-color: #000;
			text-align: center;
			cursor: pointer;
		}
		@media (min-width: 1200px) {
			.categoryDiv .itemss {
				height: 800px!important;
			}
		}

		body{
			margin:0;
			padding: 0;
			border-top: 1px solid transparent;
		}
		img{
			width:100%;
		}
		.items{
			width:1000px;
			margin: 40px auto;
		}
		.item{
			background-color: #ccc;
		}
	</style>
<!--// css -->

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.js"></script>
</head>
<body> 
<!-- banner -->
<div class="sub-banner">
		<!-- Navbar -->
		<jsp:include page="/WEB-INF/jsp/views/common/header.jsp"></jsp:include>
</div>
<!-- banner -->

<!-- gallery -->
	<div class="gallery-w3layouts" id="imgList">
		<div class="container categoryDiv">
			<h2>{{groupInfo.groName}} 图片列表</h2>
			<div class="items">
				<div class="item" v-for="(img,index) in imgList">
					<img :src="img.picPath" alt="">
					<%--<p>{{img.picDescribe}}</p>--%>
					<div class="info">
						<div class="up-cover"></div>
						<%--<span class="image-title">{{img.picDescribe}}</span>--%>
						<div class="image-ops">
							<span class="hint--top popup-with-zoom-anim" :href="'#small-dialog'+img.id">预览</span>
							<span aria-label="收藏" class="hint--top">收藏</span>
							<span aria-label="下载" :onclick="'downloadImg('+ img.id +')'" class="hint--top">下载</span>
						</div>
					</div>
					<div class="pop-up">
						<div :id="'small-dialog'+img.id" class="mfp-hide book-form small-dialog">
							<div class="pop-up-content-agileits-w3layouts">
								<div class="col-md-6 w3ls-left">
									<img :src="img.picPath" alt=" " class="img-responsive zoom-img" />
								</div>
								<div class="col-md-6 w3ls-right">
									<h4>编号：{{img.picNumber}}</h4>
									<p>描述：{{img.picDescribe}}</p>
									<div class="span span1">
										<p class="left">大小</p>
										<p class="right">:{{img.picSize}}</p>
										<div class="clearfix"></div>
									</div>
									<div class="span span2">
										<p class="left">格式</p>
										<p class="right">: {{img.picType}}</p>
										<div class="clearfix"></div>
									</div>
									<div class="span span3">
										<p class="left">分辨率</p>
										<p class="right">: 1920*1080</p>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--//gallery -->
	<script src="../../js/jquery.waterfall.js"></script>
	<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/modernizr.custom.53451.js"></script>
	<script src="../../js/vue.min.js"></script>

	<script>

		let groupList = new Vue({
			el: '#imgList',
			data: {
				imgList:null,
				groupInfo:null,
			},
			created: function () {
				this.imgList = JSON.parse('${imgPictureList}');
				this.groupInfo = JSON.parse('${groupInfo}');
			}
		});

	</script>
	<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
				});

				$('.items').waterfall({
					column:4,
					gap:20
				});
			});



			function downloadImg(num) {

				let image = new Image();
				image.src = "../../images/views/img3.png";
				// 解决跨域 Canvas 污染问题
				image.setAttribute("crossOrigin", "anonymous");
				image.onload = function () {
					let canvas = document.createElement("canvas");
					canvas.width = image.width;
					canvas.height = image.height;
					let context = canvas.getContext("2d");
					context.drawImage(image, 0, 0, image.width, image.height);
					let url = canvas.toDataURL("image/png"); //得到图片的base64编码数据
					let a = document.createElement("a"); // 生成一个a元素
					a.download = "img"+num; // 设置图片名称
					a.href = url; // 将生成的URL设置为a.href属性
					a.click()
				}
			}
	</script>

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/views/common/footer.jsp"></jsp:include>
<!-- //footer -->
</body>
</html>