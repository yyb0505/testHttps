(function($){
	function crateCommentInfo(obj){

		if(typeof(obj.comCreateDate) == "undefined" || obj.comCreateDate == ""){
			obj.comCreateDate = getNowDateFormat();
		}

		var el = "<div class='comment-info'><header><img src='"+obj.userProfile+"'></header><div class='comment-right'><h5>"+obj.userName+"</h5>"
			+"<div class='comment-content-header'><span><i class='glyphicon glyphicon-time'></i>"+obj.comCreateDate+"</span>";
		el = el+"</div><p class='content'>"+obj.comContent+"</p><div class='comment-content-footer'><div class='row'><div class='col-md-10'>";
		if(userFlag){
			el = el + "</div><div class='col-md-2'><span class='reply-btn'>回复</span><span class='comId'>"+obj.id+"</span></div></div></div><div class='reply-list'>";
		}else{
			el = el + "</div><div class='col-md-2'></div></div></div><div class='reply-list'>";
		}
		if(obj.ccData != "" && obj.ccData != undefined && obj.ccData.length > 0){
			var arr = obj.ccData;
			for(var j=0;j<arr.length;j++){
				var replyObj = arr[j];
				el = el+createReplyComment(replyObj);
			}
		}
		el = el+"</div></div></div>";
		return el;
	}

	//返回每个回复体内容
	function createReplyComment(reply){
		if(userFlag){
			var replyEl = "<div class='reply'><div><a href='javascript:void(0)' class='replyname'>"+reply.userName+"</a>:<a href='javascript:void(0)'>@"+reply.faUserName+"</a><span>"+reply.comContent+"</span></div>"
				+ "<p><span>"+reply.comCreateDate+"</span> <span class='reply-list-btn'>回复</span><span class='comId'>"+reply.id+"</span></p></div>";
		}else{
			var replyEl = "<div class='reply'><div><a href='javascript:void(0)' class='replyname'>"+reply.userName+"</a>:<a href='javascript:void(0)'>@"+reply.faUserName+"</a><span>"+reply.comContent+"</span></div>"
				+ "<p><span>"+reply.comCreateDate+"</span> </p></div>";
		}
		return replyEl;
	}

	function getNowDateFormat(){
		var nowDate = new Date();
		var year = nowDate.getFullYear();
		var month = filterNum(nowDate.getMonth()+1);
		var day = filterNum(nowDate.getDate());
		var hours = filterNum(nowDate.getHours());
		var min = filterNum(nowDate.getMinutes());
		var seconds = filterNum(nowDate.getSeconds());
		return year+"-"+month+"-"+day+" "+hours+":"+min+":"+seconds;
	}

	function filterNum(num){
		if(num < 10){
			return "0"+num;
		}else{
			return num;
		}
	}

	function replyClick(el){
		el.parent().parent().append("<div class='replybox'><textarea cols='80' rows='50' placeholder='来说几句吧......' class='mytextarea' ></textarea><span class='send'>发送</span></div>")
			.find(".send").click(function(){
			var content = $(this).prev().val();
			var comId =$(this).parent().prev().find("span.comId").html();
			alert(comId);
			if(content != ""){
				var parentEl = $(this).parent().parent().parent().parent();
				var obj = new Object();
				obj.userName=userInfo.userName;
				if(el.parent().parent().hasClass("reply")){
					obj.faUserName = el.parent().parent().find("a:first").text();
				}else{
					obj.faUserName=parentEl.find("h5").text();
				}
				obj.comContent=content;
				obj.comCreateDate = getNowDateFormat();
				var replyString = createReplyComment(obj);
				let dataObj = {relId:releaseDetail.commRelease.id,comContent:content,userId:userInfo.userId,comId};
				insertComment(dataObj);
				$(".replybox").remove();
				parentEl.find(".reply-list").append(replyString).find(".reply-list-btn:last").click(function(){alert("不能回复自己");});
			}else{
				alertContent("空内容");
			}
		});
	}

	$.fn.addCommentList=function(options){
		var defaults = {
			data:[],
			add:""
		}
		var option = $.extend(defaults, options);
		//加载数据
		if(option.data.length > 0){
			var dataList = option.data;
			var totalString = "";
			for(var i=0;i<dataList.length;i++){
				var obj = dataList[i];
				var objString = crateCommentInfo(obj);
				totalString = totalString+objString;
			}
			$(this).append(totalString).find(".reply-btn").click(function(){
				if($(this).parent().parent().find(".replybox").length > 0){
					$(".replybox").remove();
				}else{
					$(".replybox").remove();
					replyClick($(this));
				}
			});
			$(".reply-list-btn").click(function(){
				if($(this).parent().parent().find(".replybox").length > 0){
					$(".replybox").remove();
				}else{
					$(".replybox").remove();
					replyClick($(this));
				}
			})
		}

		//添加新数据
		if(option.add != ""){
			obj = option.add;
			var str = crateCommentInfo(obj);
			$(this).prepend(str).find(".reply-btn").click(function(){
				replyClick($(this));
			});
		}
	}

	
})(jQuery);