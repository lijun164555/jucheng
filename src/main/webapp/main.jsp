﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
<!-- 		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;用户管理<span>&nbsp; -->
<!-- 		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;用户列表<span>&nbsp; -->
	</div>
</div>
<div id="tips">
<!-- 	<div id="buttonGroup"> -->
<!-- 		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"> -->
<!-- 			<a>添加用户</a> -->
<!-- 		</div> -->
<!-- 		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"> -->
<!-- 			<a>查找用户</a> -->
<!-- 		</div> -->
<!-- 	</div> -->
</div>
<div id="mainContainer">
<!-- <table class="default" width="100%"> -->
<!-- 	<col width="20%"> -->
<!-- 	<col width="20%"> -->
<!-- 	<col width="40%"> -->
<!-- 	<col width="20%"> -->
<!-- 	<tr class="title"> -->
<!-- 		<td>序号</td> -->
<!-- 		<td>登录名</td> -->
<!-- 		<td>真实名</td> -->
<!-- 		<td>操作</td> -->
<!-- 	</tr> -->
<!-- 	<tr class="list"> -->
<!-- 		<td>1</td> -->
<!-- 		<td>1</td> -->
<!-- 		<td>1</td> -->
<%-- 		<td><a href="user_preRole.action?id=${user.id}">分配角色</a></td> --%>
<!-- 	</tr> -->
<!-- </table> -->
</div>
</body>
</html>