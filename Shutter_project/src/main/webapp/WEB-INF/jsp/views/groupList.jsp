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
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/popup-box.css" rel="stylesheet" type="text/css" media="all" />
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
			opacity: 1;
		}

		.gallery-grid:hover .info {
			border: 1px solid #000;
		}

		.image-title {
			position: absolute;
			left: 30px;
			top: 20px;
			right: 12px;
			font-size: 16px;
			color: #fff;
			font-weight: 600;
			z-index: 1;
			max-width: 100%;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}

		.image-ops {
			position: absolute;
			bottom: 12px;
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
			.categoryDiv .gallery-grids {
				height: 800px!important;
			}
		}
	</style>
<!--// css -->
<!-- font -->
<link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- //font -->
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
	<div class="gallery-w3layouts" id="groupList">
		<div class="container categoryDiv">
			<h2>{{categoryInfo.catName}}类别组列表</h2>
			<div class="gallery-grids">

				<div class="gallery-grid" v-for="(gro,index) in groupList">
					<a class="category book popup-with-zoom-anim  button-isi zoomIn animated" data-wow-delay=".5s" :href="'queryImgPictureListByGroId?page=1&pageSize=20&groId=' + gro.id">
						<img :src="gro.groImgPath" :alt="gro.groName"  class="img-responsive zoom-img" />
						<div class="info">
							<div class="up-cover"></div>
							<span class="image-title">{{gro.groName}}</span>
						</div>
					</a>
				</div>

			<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//gallery -->
	<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/modernizr.custom.53451.js"></script>
	<script src="../../js/vue.min.js"></script>
	<script>

		let groupList = new Vue({
			el: '#groupList',
			data: {
				groupList:null,
				categoryInfo:null,
			},
			created: function () {
				this.groupList = JSON.parse('${groupList}');
				this.categoryInfo = JSON.parse('${categoryInfo}');
			}
		});

</script>

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/views/common/footer.jsp"></jsp:include>
<!-- //footer -->
</body>
</html>