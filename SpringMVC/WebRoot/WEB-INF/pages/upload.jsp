<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'upload.jsp' starting page</title>

  </head>
  
  <body>
    This is my JSP page. <br>
 	<form action="uploadResult" method="post" enctype="multipart/form-data">
 		文件:<input type="file" name="myfiles" />
 		<br />
 		<input type="submit" value="submit">
 	</form>
  </body>
</html>
