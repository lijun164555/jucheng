<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>修改菜品类型</h2>

	<form action="modifytableaction">
		<table>
			<tr>
				<td>类型<input name="name" value="${name}"/></td>
			</tr>
	
			<tr>
			<input type="hidden" name="id"value="${id}"/>
				<td><input type="submit" value="修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>