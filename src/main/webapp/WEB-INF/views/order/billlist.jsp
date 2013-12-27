<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>  
function print() {
document.getElementById("orderdetail").action = "print";
document.getElementById("orderdetail").submit();
}
function discount(){
	var v=document.getElementById("dazhe").value
	var dz=document.getElementById("hpaid").value
	document.getElementById("paid_in").value=Math.round(v*dz)
}
</script>
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
	<form  action="bill" id="orderdetail" >
		<input type="hidden" value="${orderId}" name="orderId" />
		<table>
		<c:if test="${payStatus==0}">
		<tr>
			<td>是否开发票</td>
			<td>
			  <input type="radio" name="is_invoice" value="0" checked /> 否&nbsp
			  <input type="radio" name="is_invoice" value="1" /> 是
			</td>
		</tr>
		<tr >
			<td>结账类型</td>
			<td><input type="radio" name="bill_type" value="0" checked />现金
			<input type="radio" name="bill_type" value="1" />信用卡
			<input type="radio" name="bill_type" value="2" />会员消费
			<input type="radio" name="bill_type" value="3" />内招</td>
		</tr>
				<tr>
		  <td>打折</td>
		  <td><select onchange="discount()" id="dazhe">
<option value ="1">无</option>
  <option value ="0.95">九五折</option>
  <option value ="0.9">九折</option>
  <option value="0.85">八五折</option>
  <option value="0.8">八折</option>
  <option value="0.75">七五折</option>
  <option value="0.7">七折</option>
  <option value="0.65">六五折</option>
  <option value="0.6">六折</option>
</select></td>
		</tr>
		<tr>
	        <input type="hidden" name="hpaid" id="hpaid" value=${count/100 } />
		   <td>实付</td><td><input name="paid_in" id="paid_in" value=${count/100 } /></td>
		</tr>
		<tr>
		<td><input type="submit" value="结帐"/></td>
		</tr>
		</c:if>
			<c:if test="${payStatus==1}">
		<tr>
		<c:if test="${is_invoice==0}">
		<td>发票未打印 </td>		
		</c:if>
		<c:if test="${is_invoice==1}">
		<td>发票已打印</td>		
		</c:if>
		<td>结账方式：${billType}</td>
		</tr>
		<tr>
		<td><button type="button">已结账</button></td>
		<td><button type="button" onclick="print()">打印</button></td>
		</tr>
		</c:if>
		</table>
	</form>
</body>
</html>
