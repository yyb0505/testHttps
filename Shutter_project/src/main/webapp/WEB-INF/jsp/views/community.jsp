<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>News</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Kids Video Game Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- css -->
	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
	<style>
		/*.events-text-w3-agile ul{
			display: inline-block;
			border-bottom: 2px solid #000;
			width: 30%;
			padding: 10px;
			background-color: rgba(0,0,0,0.5);
		}
		.events-text-w3-agile h4 {
			background: #444;
			padding: 10px 0px;
			color: #fff;
			width: 30%;
			font-size: 24px;
		}
		.events-text-w3-agile p {
			font-size: 22px;
			color: #fff;
			font-weight: 600;
			position: absolute;
			bottom: 0px;
			background-color: rgba(0,0,0,0.5);
			width: 100%;
			padding: 10px;
		}
		.events-text-w3-agile ul li{
			color:#fff;
			font-weight: bold;
		}*/
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
<div id="community">
<!-- banner -->
<div class="sub-banner">
	<!-- Navbar -->
	<jsp:include page="/WEB-INF/jsp/views/common/headerComm.jsp"></jsp:include>
</div>
<!-- banner -->
<div class="events-w3layouts">
	<%--<h2>昨日动态排行榜</h2>--%>

	<div class="col-md-7 events-left-agile-agileits-w3layouts">
		<a href="single.html">
			<div v-if="commRank" class="events-text-w3-agile events-text1" style="background: url(../images/views/news1.jpg) no-repeat 0px 0px;background-size:cover;">
				<h4>{{commRank[0].relTitle}}</h4>
				<p>谁记得那瞬间，我们像永恒的画面。 </p>
				<ul>
					<li>{{commRank[0].relCreateDate}}</li>
					<li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>{{commRank[0].relPageView}}</li>
				</ul>
			</div>
		</a>
	</div>

	<div class="col-md-5 events-right-agile">
		<a href="single.html">
			<div v-if="commRank" class="events-right-top" >
				<div class="events-text-w3-agile events-text2">
					<h4>{{commRank[1].relTitle}}</h4>
					<p>想长出羽翼陪你在天边天空飞行 </p>
					<ul>
						<li>{{commRank[1].relCreateDate}}</li>
						<li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>{{commRank[1].relPageView}}</li>
					</ul>
				</div>
			</div>
		</a>
		<a href="single.html">
			<div v-if="commRank" class="events-right-bottom">
				<div class="events-text-w3-agile events-text2">
					<h4>{{commRank[2].relTitle}}</h4>
					<p>若是我会迷路，那么你是我的眼</p>
					<ul>
						<li>{{commRank[2].relCreateDate}}</li>
						<li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>{{commRank[2].relPageView}}</li>
					</ul>
				</div>
			</div>
		</a>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>

<div class="events-section2-agileinfo">
	<div class="container">

		<div class="blog1-w3ls" v-if="latestReleaseList"  v-for="(rel,index) in latestReleaseList">
			<div class="col-md-4 blog-image-w3l">
				<a href="single.html"><img src="../images/views/news1.jpg" alt=" " /></a>
			</div>
			<div class="col-md-8 blog-text-w3ls">
				<a href="single.html"><h4>{{rel.relTitle}}</h4></a>
				<div class="item_info">
					<ul>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>{{rel.userId}}</a></li>
						<li><i class="glyphicon glyphicon-calendar"></i>{{rel.relCreateDate}}</li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i>{{rel.relPageView}}</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-heart"></i>999+ 喜欢</a></li>
					</ul>
				</div>
				<p>{{rel.relDescribe}}</p>
				<a :href="'releaseDetail?relId='+rel.id" class="blog-read" >查看更多</a>
			</div>
			<div class="clearfix"></div>
		</div>

		<%--<div class="blog2-w3ls">
			<div class="col-md-4 blog-image-w3l">
				<a href="single.html"><img src="../images/views/news2.jpg" alt=" " /></a>
			</div>
			<div class="col-md-8 blog-text-w3ls">
				<a href="single.html"><h4>《即兴》</h4></a>
				<div class="item_info">
					<ul>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>小咪</a></li>
						<li><i class="glyphicon glyphicon-calendar"></i>2020-11-19</li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i>141697 评论</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-heart"></i>999+ 喜欢</a></li>
					</ul>
				</div>
				<p>你现在好吗，会不会偶尔想起她，分开的时候，以为了了牵挂，其实爱并不可怕，坚持是方法，要是你能陪我到生命尽头啊，遗憾是常有吧，如果你能对我表达，那些误解其实就能停下，爱情是粗茶，一触碰就放不下，也许你走了我世界都崩塌。</p>
				<a href="single.html" class="blog-read" >查看更多</a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="blog3-w3ls">
			<div class="col-md-4 blog-image-w3l">
				<a href="single.html"><img src="../images/views/news3.jpg" alt=" " /></a>
			</div>
			<div class="col-md-8 blog-text-w3ls">
				<a href="single.html"><h4>《可乐》</h4></a>
				<div class="item_info">
					<ul>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>赵紫骅</a></li>
						<li><i class="glyphicon glyphicon-calendar"></i>2014-05-05</li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i>570171 评论</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-heart"></i>999+ 喜欢</a></li>
					</ul>
				</div>
				<p>可惜在遇见我那天你并不快乐，可能是因为我们相遇的太晚了，可是我要走了，可温暖要走了，可否有另一个我在你身后给予快乐，可当我牵着你的手傻乎乎的乐，渴望的爱情终于在我生命出现了，可时间倒数了 可你的答案停住了，可想到你的脸我还是很快乐，可能你不快乐 可惜你不快乐，可能是我的爱情它来的太晚了，可它给了你些什么 你是不是真快乐。</p>
				<a href="single.html" class="blog-read" >查看更多</a>
			</div>
			<div class="clearfix"></div>
		</div>--%>
	</div>
</div>

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/views/common/footer.jsp"></jsp:include>
<!-- //footer -->
</div>
<script src="../../js/vue.min.js"></script>
<script>

	let community = new Vue({
		el: '#community',
		data: {
			commRank: null,
			latestReleaseList: null,
		},
		created: function () {
			/*this.commRank = JSON.parse('${commRank}');
			this.latestReleaseList = JSON.parse('${latestReleaseList}');
			console.log('${latestReleaseList}');*/

		},
		mounted() {
			this.initData();
		},
		methods:{
			initData(){
				let that = this;
				$.ajax({
					url: "community",
					type: "post",
					dataType:"json",
					data:{number:3,page:1,pageSize:10},
					success: function(data){
						if(data.code == 0){
							that.commRank = JSON.parse(data.data.commRank);
							console.log("commRank:"+data.data.commRank);
							that.latestReleaseList = JSON.parse(data.data.latestReleaseList);
							console.log("latestReleaseList:"+data.data.latestReleaseList);
						}else{
							alert("数据查询失败！");
						}
					}
				});
			}
		}
	});
</script>
</body>
</html>