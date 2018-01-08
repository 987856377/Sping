<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>starting page</title>

  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="/SpringMVC/servlet/FileUploadServlet" method="post" enctype="multipart/form-data">
    	请选择文件:<input type="file" name="文件"><br>
    			 <input type="submit" value="提交">
    </form>
  </body>
</html>
