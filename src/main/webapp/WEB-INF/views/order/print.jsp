<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div id="myPrintArea">
		<h2>桌号 ${table }</h2>

		<table>
			<tr>
				<td width="30%">菜名</td>
				<td width="30%">数量</td>
				<td>价格</td>
			</tr>
			<c:forEach items="${orderVOList }" var="oreder">
				<tr>
					<td width="30%"><c:out value="${oreder.menu_name }" /></td>
					<td width="30%"><c:out value="${oreder.amount }" /></td>
					<td>:<c:out value="${oreder.price/100 }" /> 元
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td>--------------------</td>
			</tr>
			<tr>
				<td>共计：</td>
				<td>${count/100}</td>
			</tr>
		</table>
	</div>
	<form action="bill" id="orderdetail">
		<input type="hidden" value="${orderId}" name="orderId" />
		<table>
			<c:if test="${payStatus==0}">
				<tr bgcolor="red">
					<td>是否打印发票</td>
					<td><input type="radio" name="is_invoice" value="0" checked />
						否</td>
					<td><input type="radio" name="is_invoice" value="1" /> 是</td>
				</tr>
				<tr bgcolor="red">
					<td>结账类型</td>
					<td><input type="radio" name="bill_type" value="0" checked />现金</td>
					<td><input type="radio" name="bill_type" value="1" />信用卡</td>
					<td><input type="radio" name="bill_type" value="2" />会员消费</td>
					<td><input type="radio" name="bill_type" value="3" />内招</td>
				</tr>
				<tr>
					<td>实付<input name="paid_in" value=${count/100 } /></td>
				</tr>
			</c:if>
			<c:if test="${payStatus==1}">
				<tr>
					<c:if test="${is_invoice==0}">
						<td>发票未打印</td>
					</c:if>
					<c:if test="${is_invoice==1}">
						<td>发票已打印</td>
					</c:if>
					<td>结账方式：${billType}</td>
				</tr>
				<tr>
					<td>实付 :${paid_in/100 }</td>
				</tr>
				<tr>
					<td><input id="biuuu_button" type="button" value="打印" /></td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
<applet id="TestApplet" archive="print.jar" code="TestApplet.class" codebase="." width="100" height="100"></applet>
</html>

