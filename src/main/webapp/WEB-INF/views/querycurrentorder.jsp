
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script>
	function modify(flag) {
		var val=document.getElementById("table").value;
		if(isNaN(val)||val<1){
	         alert("请输入为数字的桌号！");
	         return ;
			}
		if(flag==1){
			document.getElementById("bill").action = "orderlist";
			document.getElementById("bill").submit();
		}else{
			document.getElementById("bill").action = "order/billlist";
			document.getElementById("bill").submit();
		}
		
	}
</script>
<html>
<body>
	<h2>订单查询</h2>
	<form  id="bill">
		桌号：<input name="table" id="table"/>
		<button onclick="modify(1)" type="button">修改</button>
		<button onclick="modify(2)" type="button">结算</button>
	</form>
</body>
</html>

