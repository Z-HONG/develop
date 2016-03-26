<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   	<form action="${pageContext.request.contextPath }/servlet/ValidateCodeDemo">
   		name:<input type="text" name= "name" /><br/>
   		password:<input type="password" name= "password" /><br/>
   		<img  src="${pageContext.request.contextPath }/servlet/ValidateCodeImage" id="im" onclick="changeCaptcha()"/><br/>
   		请输入验证码:<input type="text" name= "captcha" /><br/>
   		<input type="submit" /> 
   	</form>
   	<script type="text/javascript">
   		function changeCaptcha(){
   			document.getElementById("im").src = "${pageContext.request.contextPath }/servlet/ValidateCodeImage?time="
   			+new Date().getTime();
   		}
   	</script>
  </body>
</html>
