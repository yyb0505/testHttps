//jquery的原型可以通过$.fn来访问
//插件就是在原型上添加方法
$.fn.waterfall=function(params){
			//console.log(this);
			var container=$(this);
			var images=container.children();
			var cWidth=container.width();
			//假设有5列
			var col=params.column;
			var gap=params.gap;   //设置图片间的间距
			var width=(cWidth-4*gap)/col;
			var h=[];     //定义一个数组来存放每一列当前的高度

			container.css('position','relative');  //父盒子相对定位
			
			images.each(function(key,val){
				// $(this).css('width',width);
				// var index=$(this).index();
				//key:索引值   val:原生DOM对象（div.item）
				//console.log(key,val);
				$(val).css({
					'width':width,
					'position':'absolute'
				});
				
				if(key<col)   //第一行单独处理
				{
					$(val).css({
						'top':0,
						'left':key*(width+gap)
					});
					h.push($(val).height()+gap);
				}
				else  //其它行优先填补较矮的那一列
				{
					var min_key=0;
					var min_val=h[0];
					for(var i=0;i<h.length;i++)
					{
						if(min_val>h[i]){
							min_val=h[i];
							min_key=i;
						}
					}
					$(val).css({
						'top':min_val,
						'left':min_key*(width+gap)
					});
					h[min_key]+=$(val).height()+gap;   //填补完图片后将对应列的高度更新
				}
			});
			//因为container中所有的子元素都绝对定位了，所以container丢失了高度
			
			var max_val=h[0];
			for(var i=0;i<h.length;i++)
			{
				if(max_val<h[i]) max_val=h[i];
			}
			container.height(max_val);    //container重新得到高度
		}