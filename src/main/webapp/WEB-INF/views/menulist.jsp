<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>菜单列表</h2>

	<table border="1">
		<tr>
		    <td width="2%">编号</td>
			<td width="18%">菜名</td>
			<td width="10%">价格</td>
			<td width="10%">类型</td>
			<td width="10%">菜名二</td>
			<td width="10%">菜名三</td>
			<td width="20%">状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${menuList }" var="menu">
			<tr>
			   <td width="2%"><c:out value="${menu.id}" /></td>
				<td width="18%"><c:out value="${menu.name}" /></td>
				<td width="10%"><c:out value="${menu.price/100 }元" /></td>
				<td width="10%"><c:out value="${menu.typeName }" /></td>
				<td width="10%"><c:out value="${menu.secondName }" /></td>
				<td width="10%"><c:out value="${menu.thirdName }" /></td>
				<td width="20%"><c:if test="${menu.status==0}">
						<c:out value="使用中" />
					</c:if> <c:if test="${menu.status==1}">
						<c:out value="已停用" />
					</c:if></td>
				<td><a href="modifymenu?menuId=${menu.id}">修改</a><a
					href="deletemenu?id=${menu.id}&status=${menu.status}"> <c:if test="${menu.status==0}">删除</c:if>
					<c:if test="${menu.status==1}">启用</c:if>
					</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
