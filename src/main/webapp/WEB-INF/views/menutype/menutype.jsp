<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
<body>
	<h2>新增菜单类型</h2>
	<form action="addmenutype">
		<table>
			<tr>
				<td>类型<input name="name" /></td>
			</tr>
			<tr>
				<td>灶头<input name="stove" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
