<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>菜单类型列表</h2>

	<table border="1">
		<tr>
			<td width="20%">id</td>
			<td width="20%">类型</td>
			<td width="20%">灶头</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${menuTypeList }" var="menuType">
			<tr>
				<td width="20%"><c:out value="${menuType.id}" /></td>
				<td width="20%"><c:out value="${menuType.name}" /></td>
				<td width="20%"><c:out value="${menuType.stove }" /></td>
				<td><a href="modifymenutype?menuTypeId=${menuType.id}&&name=${menuType.name}&&stove=${menuType.stove }">修改</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
