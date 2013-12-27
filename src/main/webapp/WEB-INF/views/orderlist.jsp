<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function modify() {
		var ele = document.forms['frm'].elements;
		var str = ""
		for ( var i = 0; i < ele.length; i++) {
			if (ele[i].type.toLowerCase() == "text") {
				if (str == "") {
					str = ele[i].name + ":" + ele[i].value
				} else {
					str = str + "," + ele[i].name + ":" + ele[i].value
				}

			}
		}
		document.getElementById("modifyAll").value = str;
		document.getElementById("frm").action = "modifyOrderDetail";
		document.getElementById("frm").submit();
	}
</script>
<html>
<body>
	<form name="frm" id="frm">
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
					<td width="30%"><input value="${oreder.amount }"
						name="${oreder.menuId}" /></td>
					<td>:<c:out value="${oreder.price/100 }" /> 元
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="modifyAll" id="modifyAll" /> <input
			type="hidden" value="${orderId}" name="orderId" />
		<button onclick="modify()" type="button">修改</button>
		<!-- 		<input type="button"  onclick="submit()" value="修改" /> -->
	</form>
</body>
</html>
