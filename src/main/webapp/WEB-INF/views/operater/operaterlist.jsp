<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>操作人员列表</h2>

	<table border="1">
		<tr>
			<td width="20%">id</td>
			<td width="20%">姓名</td>
			<td width="20%">编号</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${operaterList}" var="operater">
			<tr>
				<td width="20%"><c:out value="${operater.id}" /></td>
				<td width="20%"><c:out value="${operater.name}" /></td>
				<td width="20%"><c:out value="${operater.password }" /></td>
				<td><a href="modifyoperater?operaterId=${operater.id}&&name=${operater.name}&&password=${operater.password }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
