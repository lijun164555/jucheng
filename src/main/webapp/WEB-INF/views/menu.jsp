<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<style type="text/css">
.radius {
    border-width: 1px;
    border-style: solid;
    -moz-border-radius: 11px;
    -khtml-border-radius: 11px;
    -webkit-border-radius: 11px;
    border-radius: 11px;
    padding:5px;
}
.radius th {background-color:#0000ff;color:#ffffff;}
.radius tr:nth-child(odd) {background-color:#FF0000;}
.radius tr:nth-child(even) {background-color:#00ff00;}
.radius tr:hover{background-color:#FF0;}
.white_content {
 display: none;
 position: absolute;
 top: 25%;
 left: 25%;
 width: 50%;
 padding: 6px 16px;
 border: 12px solid #D6E9F1;
 background-color: white;
 z-index:1002;
 overflow: auto;
}
.close {
 float:right;
 clear:both;
 width:100%;
 text-align:right;
 margin:0 0 6px 0
}
</style>
<script type="text/javascript">
function hide(tag){
	 var light=document.getElementById(tag);
	 var fade=document.getElementById('fade');
	 light.style.display='none';
	 fade.style.display='none';
	}
function show(tag){
	 var light=document.getElementById(tag);
	 var fade=document.getElementById('fade');
	 light.style.display='block';
	 fade.style.display='block';
	 }

</script>
<body>
	<h2>新增菜单</h2>
	<form action="addmenu">
		<table>
			<tr>
				<td>菜&nbsp;&nbsp;&nbsp;&nbsp;名<input name="name" /></td>
			</tr>
			<tr>
				<td>价&nbsp;&nbsp;&nbsp;&nbsp;格<input name="price" /></td>
			</tr>
			<tr>
				<td>图&nbsp;&nbsp;&nbsp;&nbsp;片<input name="picUrl" /><a href="javascript:void(0)" onclick="show('light2')">上传图片</a></td>
				
			</tr>
			
			<tr>
				<td>类&nbsp;&nbsp;&nbsp;&nbsp;型  
				<select name="type">
				  <option value="">--请选择--</option>  
				<c:forEach items="${list}" var="menuType">
				<option value=${menuType.id} }>${menuType.name}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>菜名二<input name="secondName" />（可以输入其他语言）</td>
			</tr>
			<tr>
				<td>菜名三<input name="thirdName"/>（可以输入其他语言）</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	<div id="light2" class="white_content">
      <div class="close"><a href="javascript:void(0)" onclick="hide('light2')"> 关闭</a></div>
      <div class="con"> 
       		<form action="menu/uploadPic" method="post" enctype="multipart/form-data">
                  <input name="imgFile" id="imgFile" type="file" />
                  <p><button type="submit">Read</button></p>    
            </form>
      </div>
</div>
<div id="fade" class="black_overlay"></div>
</body>
</html>
