<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <h1>导入Excel</h1>
<hr>
    <form  id="readReportForm" action="importExcel" method="post" enctype="multipart/form-data"  >  
            <input  type="file" name="file" />  
            <p><button type="submit">Read</button></p>    
        </form> 
</html>