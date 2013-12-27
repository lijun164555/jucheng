<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>订单列表</h2>

	<table border="1">
		<tr>
			<td width="10%">id</td>
			<td width="10%">桌号</td>
			<td width="10%">结账状态</td>
			<td width="20%">开始时间</td>
			<td width="20%">结账时间</td>
			<td width="10%">操作</td>
		</tr>
		<c:forEach items="${orderList }" var="order">
			<tr>
				<td width="10%"><c:out value="${order.id}" /></td>
				<td width="10%"><c:out value="${order.tableNum}" /></td>
				<td width="10%"><c:if test="${order.payStatus==0}">
						<c:out value="未结账" />
					</c:if> <c:if test="${order.payStatus==1}">
						<c:out value="已结账" />
					</c:if></td>
				<td width="20%"><c:out value="${order.showCreatDate}" /></td>
				<td width="20%"><c:out value="${order.showModifyDate}" /> </td>
				<td width="10%"><a
					href="orderdetaillist?id=${order.id}&&table=${order.tableNum}">查看</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
