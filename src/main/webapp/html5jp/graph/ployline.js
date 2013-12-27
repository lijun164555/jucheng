/**
*显示坐标位置的解决方案：
*1.显示区域的x轴不变，y轴设为8，让他显示在最顶上，不同的颜色的线在坐标显示的时候用不同颜色的字体表示
*2.每条线设定固定显示区域的x轴和y轴放在最右边，在接触到哪条线的数据点得时候动态变动他对应显示区域的数据
*3.动态变化显示区域的x轴和y轴，让他跟随选中的数据点移动，为了避免擦除时擦除掉线的痕迹，在执行mouseMove事件的时候重新绘制一下图、、
但是如果数据庞大可能会有延迟，性能会下降、、
*/

function XY(x,y){
	this.x = x;
	this.y = y;
}
var graph_leftSpace = 40;
var graph_rightSpace = 100;
var graph_topSpace = 20;
var graph_bottomSpace = 30;
var showMax = 53;//最大显示数据个数


function Graph(graph){
	//得到canvas对象
	var cv = document.getElementById(graph);	
	//上下文对象
	var context;
	if(cv.getContext("2d")){
			context = cv.getContext("2d");
		}
	var arrB = new Array();
	function onMouseMove(evt,arrPoint,count,arrN) {
		
	// 获取鼠标在 canvas 中的坐标位置
		if (evt.layerX || evt.layerX == 0) { // FireFox 
			g_x = evt.layerX; 
			g_y = evt.layerY; 
			for(var i = 0;i<arrPoint.length;i++){
				if(g_x==arrPoint[i].x||g_x==arrPoint[i].x+1||g_x==arrPoint[i].x+2||g_x==arrPoint[i].x-1||g_x==arrPoint[i].x-2){ 
					if(g_x==arrPoint[i].x||g_x==arrPoint[i].x+1||g_x==arrPoint[i].x+2||g_x==arrPoint[i].x-1||g_x==arrPoint[i].x-2){
						var xy = new XY(arrPoint[i].x,arrPoint[i].y);
						arrN.push(xy);
						//突出显示
						for(var j =0;j<arrB.length;j++){
							context.fillRect(arrB[j].x-2,arrB[j].y-2,4,4);
						}
						
						context.save();
						context.fillStyle = "red";	
						for(var j =0;j<arrN.length;j++){
							context.fillRect(arrN[j].x-2,arrN[j].y-2,4,4);
						}
						
						context.restore();
						context.clearRect(cv.width-graph_rightSpace+31,count*25+graph_topSpace+1,48,18);
						var text = (arrPoint[i].x-graph_leftSpace)+","+(cv.height-graph_topSpace-graph_bottomSpace-arrPoint[i].y+graph_topSpace);
						context.fillText(text,cv.width-graph_rightSpace+35,count*25+graph_topSpace+15);
						for(var j = 0;j<arrN.length;j++){
							var xy = new XY(arrN[j].x,arrN[j].y);
							arrB[j] = xy;
						}
						
						//alert("d");
					}else{
						context.clearRect(cv.width-graph_rightSpace+31,count*25+graph_topSpace+1,48,18);
						context.fillRect(x-2,y-2,4,4);
					}
				}
			}
			
			
			/*if(ctx.isPointInPath(g_x,g_y)){
				ctx.clearRect(0,0,600,50);
				ctx.fillText(g_x+","+g_y,g_x,20);
			}else{
				ctx.clearRect(0,0,600,50);
			}*/
		} 

	} 
	function move(evt,arr){
		var arrN = new Array();
		for(var i = 0;i<arr.length;i++){
			onMouseMove(evt,arr[i],i,arrN);
		}
	
	}
	
	this.draw = function(name,data){
		var draw = this;
		this.arr = new Array();
		this.color = ["green","blue","cyan","gold","pink","tan","aqua"];
		//创建上下文对象
		context.lineWidth = 2;
		context.save();
		//边框描写
		context.fillText(name,cv.width/2-20,graph_topSpace-5);
		context.strokeRect(graph_leftSpace,graph_topSpace,cv.width-graph_leftSpace-graph_rightSpace,cv.height-graph_topSpace-graph_bottomSpace);
		//context.fillText("O",graph_leftSpace-6,cv.height-graph_topSpace+3);
		context.lineWidth = 1;
		context.beginPath();
		context.arc(graph_leftSpace-5,cv.height-graph_topSpace-2,5,0,Math.PI*2,true);
		context.closePath();
		context.stroke();
		context.restore();
		var height = cv.height-graph_bottomSpace;
		for(var i = 10;i<=height-graph_topSpace;i+=10){
			context.fillText(i,graph_leftSpace-context.measureText(i).width-3,height-i+3)
		}
		var width = cv.width-graph_leftSpace;
		for(var i =20;i<width-graph_rightSpace;i+=20){
			context.fillText(i,i+graph_leftSpace-5,cv.height-graph_bottomSpace+12)
		}
		
		
		for(var i = 0;i<data.length;i++){
			context.strokeStyle = this.color[i];
			var arrPoint = new Array();
			var startCount = 0;//开始项
			//判断data的长度,如果大于50则显示后50项
			if(data[i].length>50){
				startCount = data[i].length-showMax;
			}
			context.beginPath();
			for(var j = startCount+1;j<data[i].length;j++){
			var xj = data[i][j].x+graph_leftSpace-(startCount*10);
			var yj = cv.height-graph_bottomSpace-data[i][j].y;
				context.lineTo(xj,yj);
				context.fillRect(xj-2,yj-2,4,4);
				var xy = new XY(xj,yj);
				arrPoint.push(xy);
			}
			context.stroke();
			context.fillText(data[i][0].name,cv.width-graph_rightSpace+6,i*25+graph_topSpace+15);
			context.strokeRect(cv.width-graph_rightSpace+30,i*25+graph_topSpace,50,20);
			this.arr.push(arrPoint);
		}
		
		
		
		//添加事件
		cv.addEventListener('mousemove', function(evt){move(evt,draw.arr);}, false);//鼠标移动事件
	}
	
	
	
	
}