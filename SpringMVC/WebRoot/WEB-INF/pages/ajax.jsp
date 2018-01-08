<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

    <title>My JSP 'ajax.jsp' starting page</title>
    
	<script type="text/javascript">
		$(function(){
			getInfo();
		});
		
		function getInfo(){
			$.ajax({
				type:"get",
				url:"user/ajax",
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				data:"data",
				success:function(data){
					alert("information:  "+data.name);
				}
			
			});
			
		}
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <input type="button" onClick="getInfo()">
  </body>
</html>
