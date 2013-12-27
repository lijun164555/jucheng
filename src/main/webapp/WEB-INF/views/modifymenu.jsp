
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>修改菜单</h2>

	<form action="modifymenuaction">
		<table>
			<tr>
				<td>菜&nbsp;&nbsp;&nbsp;&nbsp;名<input name="name" value="${menu.name}"/></td>
			</tr>
			<tr>
				<td>价&nbsp;&nbsp;&nbsp;&nbsp;格<input name="price" value="${menu.price}"/>(分)</td>
			</tr>
			<tr>
				<td>图&nbsp;&nbsp;&nbsp;&nbsp;片<input name="picUrl" value="${menu.picUrl}"/></td>
			</tr>
			<tr>
				<td>类&nbsp;&nbsp;&nbsp;&nbsp;型  
				<select name="type">
				  <option value="">--请选择--</option>  
				<c:forEach items="${list}" var="menuType">
				<option value=${menuType.id}   <c:if test="${menu.typeId==menuType.id}">selected </c:if>>${menuType.name}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>菜名二<input name="secondName"  value="${menu.secondName}"/>（可以输入其他语言）</td>
			</tr>
			<tr>
				<td>菜名三<input name="thirdName"  value="${menu.thirdName}"/>（可以输入其他语言）</td>
			</tr>
			<tr>
				<td>就餐类型<input name="eatType"  value="${menu.eatType}"/></td>
			</tr>
			<tr>
			<input type="hidden" name="id"value="${menu.id}" />
				<td><input type="submit" value="修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>