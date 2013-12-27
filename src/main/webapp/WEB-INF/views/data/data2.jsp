<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<title>折線グラフ サンプル 2 - jsライブラリ - HTML5.JP</title>
<style type="text/css">
canvas {border:1px solid #4c4c4c;}
</style>
<!--[if IE]><script type="text/javascript" src="../html5jp/excanvas/excanvas.js"></script><![endif]-->
<script type="text/javascript" src="../html5jp/graph/line.js"></script>
<script type="text/javascript">
window.onload = function() {
	var lg = new html5jp.graph.line("sample");
	if( ! lg ) { return; }
	var items = [
		["商品A", 20, 58, 40, 14, 38, 20, 40],
		["商品B", 10, 14, 58, 80, 70, 90, 20]
	];
	var params = {
		x: ["ri'q", "日", "月", "火", "水", "木", "金", "土"],
		y: ["注文数(個)", 0, 20, 40, 60, 80, 100],
		yMax: 100,
		yMin: 0,
		lineWidth: [1,2],
		dotRadius: [3,4],
		dotType: ["disc", "square"]
	};
	lg.draw(items, params);
};
</script>
</head>
<body>
<h1>折線グラフ サンプル 2 - jsライブラリ - HTML5.JP</h1>
<div><canvas width="400" height="300" id="sample"></canvas></div>
</body>
</html>