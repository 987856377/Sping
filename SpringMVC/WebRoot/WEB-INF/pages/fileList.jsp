<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'fileList.jsp' starting page</title>

  </head>
  
  <body>
    This is my JSP page. <br> 
    <c:forEach var="file" items="${fileNameMap }">
    	<c:url var="fileurl" value="downloadResult">
    		<c:param name="filename" value="${file.key }"></c:param>
    	</c:url>
    	${file.value }<a href=${fileurl }>下载</a><br>
    </c:forEach>
  </body>
</html>
