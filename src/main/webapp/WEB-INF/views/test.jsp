<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>测试显示结果！</h2>

	<table border="1">
		<tr>
			<th>配置项编号</th>
			<th>配置项名称</th>
			<th>配置项值</th>
			<th>配置项描述</th>
		</tr>
		<c:forEach items="${configs }" var="config">
			<tr>
				<td><c:out value="${config.code }"/></td>
				<td><c:out value="${config.name }"/></td>
				<td><c:out value="${config.value }"/></td>
				<td><c:out value="${config.description }"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
