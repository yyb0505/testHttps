<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shutter</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Kids Video Game Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="screen" property="" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--// css -->
<!-- font -->
<link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.js"></script>

</head>
<body>
<div id="indexVue">
	<!-- Header -->
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/views/common/header.jsp"></jsp:include>
		<!-- Slider -->
		<div class="slider">
			<ul class="rslides" id="slider" >
				<li v-for="(iss,index) in imgPlayShowList">
					<img :src="iss.sliPath" alt="" />
				</li>
			</ul>
		</div>
		<!-- //Slider -->

	</div>
	<!-- Banner-Slider-JavaScript -->
	<script src="../js/responsiveslides.min.js"></script>
	<script>
		$(function () {
			$("#slider").responsiveSlides({
				auto: true,
				nav: true,
				speed: 800,
				namespace: "callbacks",
				pager: true,
			});
		});
	</script>
	<!-- //Banner-Slider-JavaScript -->
	<!-- //Header -->

	<!-- trend -->
	<div class="trend-w3layouts">
		<div class="container">
			<h2>热门分类</h2>
			<ul id="flexiselDemo1">
					<li v-for="(cate,index) in hotCategory">
						<div class="trend-grid">
							<h4>{{cate.catName}}</h4>
							<a :href="'queryImgGroupListByCatId?catId=' + cate.id "><img :src="cate.catImgPath" alt=" " class="img-responsive" /></a>
						</div>
					</li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo1").flexisel({
							visibleItems: 4,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
							responsiveBreakpoints: {
								portrait: {
									changePoint:480,
									visibleItems: 2
								},
								landscape: {
									changePoint:640,
									visibleItems:3
								},
								tablet: {
									changePoint:768,
									visibleItems: 4
								}
							}
						});

					});
			</script>
			<script type="text/javascript" src="../js/jquery.flexisel.js"></script>
		</div>
	</div>
	<!-- //trend -->

	<!-- new games -->
	<div class="new-w3-agile">
		<div class="container">
			<h3>最新专题</h3>
			<div class="col-md-3 new-grid-w3l view view-eighth" v-for="(cate,index) in commCategory">
				<img :src="cate.catImgPath" alt=" " />
				<div class="mask">
					<p>{{cate.catName}}</p>
					<a href="releaseDetail.jsp"><h4>点击这里</h4></a>
					<p>了解更多</p>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //new games-->

	<div class="services-bottom-w3-agileits">
			<div class="container">
				<div class="wthree_info">
					<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<div class="wthree_info_grid">
										<h3>同舟共济，全球战疫！</h3>
										<p>积极的态度、正确的思维、友善的行动、负责任的担当，是战胜病毒这个共同敌人的唯一选择。</p>
										<a href="releaseDetail.jsp" class="learn">了解更多</a>
									</div>
								</li>
								<li>
									<div class="wthree_info_grid">
										<h3>五一踏青，想好去哪里了吗？</h3>
										<p>五一的武汉，是什么样子？</p>
										<a href="releaseDetail.jsp" class="learn">了解更多</a>
									</div>
								</li>
								<li>
									<div class="wthree_info_grid">
										<h3>五四青年节</h3>
										<p>还记得1919年的今天发生了什么吗？</p>
										<a href="releaseDetail.jsp" class="learn">了解更多</a>
									</div>
								</li>
							</ul>
						</div>
					</section>
							<!-- flexSlider -->

								<script defer src="../js/jquery.flexslider.js"></script>
								<script type="text/javascript">
								$(window).load(function(){
								  $('.flexslider').flexslider({
									animation: "slide",
									start: function(slider){
									  $('body').removeClass('loading');
									}
								  });
								});
							  </script>
							<!-- //flexSlider -->
				</div>
			</div>
		</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/jsp/views/common/footer.jsp"></jsp:include>
	<!-- //footer -->
</div>

<script src="../../js/vue.min.js"></script>
<script>

	let indexVue = new Vue({
		el: '#indexVue',
		data: {
			imgPlayShowList: null, 	//存放轮播图信息
			hotCategory: null,		//存放热门类别信息
			commCategory: null		//存放普通类别信息
		},
		created: function () {
			this.imgPlayShowList = JSON.parse('${issp}');
			this.hotCategory = JSON.parse('${hotCategory}');
			this.commCategory = JSON.parse('${commCategory}');
		}
	});

</script>
</body>
</html>