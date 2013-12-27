<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link href="script/test.js">  
</head>
<body>
	<h2>聚成科技</h2>
	<%
        String errorMess=(String)request.getAttribute("errorMess");
        if(errorMess!=null){
    %>
    　　<%=errorMess %>
    <%} %>
    <form name="form1" action="login" method="post">
            　　　　　登录<br>
                    用户名:<input type="text" name="username" size="10"><br>
                     密　码:<input type="password" name="password" size="10"><br>
          　　　　　<input type="submit" name="submit"value="登录">    
    </form>
</body>
</html>
