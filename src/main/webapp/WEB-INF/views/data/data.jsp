<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
	<title>ployline Api</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript" src="../html5jp/graph/ployline.js"></script>
	<script type="text/javascript">
	function load()
	{
		//????:json
		data = [
		[//cpu
		{name:"销售额"},
		{x:0,y:10},{x:10,y:80},{x:20,y:65},{x:30,y:55},{x:40,y:50},{x:50,y:49},{x:60,y:50},{x:70,y:55},
		{x:80,y:62},{x:90,y:70},{x:100,y:80},{x:110,y:90},{x:120,y:98},{x:130,y:102},{x:140,y:105},{x:150,y:106},
		{x:160,y:104},{x:170,y:100},{x:180,y:95},{x:190,y:88},{x:200,y:80},{x:210,y:72},{x:220,y:65},{x:230,y:60},{x:240,y:55},
		{x:250,y:52},{x:260,y:50},{x:270,y:49},{x:280,y:50},{x:290,y:51},{x:300,y:53},{x:310,y:55},{x:320,y:58},
		{x:330,y:60 },{x:340,y:61},{x:350,y:59},{x:360,y:52},{x:370,y:42},{x:380,y:32},{x:390,y:25},{x:400,y:20},
		{x:410,y:19},{x:420,y:20},{x:430,y:22},{x:440,y:25},{x:450,y:30},{x:460,y:38},{x:470,y:50},{x:480,y:70},{x:490,y:80},{x:500,y:90},{x:510,y:90},
		//{x:520,y:120},{x:530,y:130}
	]
// 		,
// 		[//rmb
// 		{name:"rmb"},
// 		{x:0,y:50},{x:10,y:60},{x:20,y:75},{x:30,y:95},{x:40,y:90},{x:50,y:80},{x:60,y:85},{x:70,y:90},{x:80,y:100},{x:90,y:95},
// 		{x:100,y:90},{x:110,y:90},{x:120,y:85},{x:130,y:75},{x:140,y:80},{x:150,y:90},{x:160,y:105},{x:170,y:110},{x:180,y:105},{x:190,y:100}
// 		],
// 		[//jjh
// 		{name:"jjh"},
// 		{x:0,y:0},{x:10,y:20},{x:20,y:54},{x:30,y:45},{x:40,y:32},{x:50,y:65},{x:60,y:78},{x:70,y:95},{x:80,y:135},{x:150,y:120}
// 		]
		];
		
		data1 = [[{name:"jjh"},{x:0,y:0},{x:10,y:20},{x:20,y:54},{x:30,y:45},{x:40,y:32},{x:50,y:65},{x:60,y:78},{x:70,y:95},{x:80,y:135},{x:150,y:120}]];
		
		var graph = new Graph("jgraph");
		graph.draw("销售额",data);
		var graph1 = new Graph("jgraph1");
		graph1.draw("ram",data1);
	}
	</script>
</head>
<body onload="load();">
	<div class="page">
		<canvas id="jgraph" width="650" height="200" style="position:absolute;top:200px;left:100px;border:1px solid black;background-color:#eee">销售额</canvas>
<!-- 		<canvas id="jgraph1" width="650" height="200" style="position:absolute;top:500px;left:100px;border:1px solid black;background-color:#ffffcc">‰Ø¿¿∆˜≤ª÷ß≥÷</canvas> -->
		
	</div>
</body></html>
	