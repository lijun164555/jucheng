<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>修改操作人员列表</h2>

	<form action="modifyoperateraction">
		<table>
			<tr>
				<td>姓名<input name="name" value="${name}"/></td>
			</tr>
			<tr>
				<td>编号<input name="password" value="${password}"/></td>
			</tr>
			<tr>
			<input type="hidden" name="id"value="${operaterId}"/>
				<td><input type="submit" value="修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>