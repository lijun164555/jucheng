<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>餐桌列表</h2>

	<table border="1">
		<tr>
			<td width="20%">id</td>
			<td width="30%">名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${tableList }" var="table">
			<tr>
				<td width="20%"><c:out value="${table.id}" /></td>
				<td width="20%"><c:out value="${table.name}" /></td>
				<td><a href="modifytable?id=${table.id}&&name=${table.name}">修改</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
