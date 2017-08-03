<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
    <form action="simple.action" method="post" enctype="multipart/form-data">
    	请选择上传文件:<input type="file" name="abc"  >
    	<input type="submit" value="上传">
    </form>
    <hr/>
    <form action="multi.action" method="post" enctype="multipart/form-data">
    	请选择上传文件:<input type="file" name="imgs" accept=".jpg,.jpeg,.png" >请输入文件名<input type="text" name="imgName"  ><br/>
    	请选择上传文件:<input type="file" name="imgs"  >请输入文件名<input type="text" name="imgName"  ><br/>
    	请选择上传文件:<input type="file" name="imgs"  >请输入文件名<input type="text" name="imgName"  ><br/>
    	请选择上传文件:<input type="file" name="imgs"  >请输入文件名<input type="text" name="imgName"  ><br/>
    	请选择上传文件:<input type="file" name="imgs"  >请输入文件名<input type="text" name="imgName"  ><br/>
    	请选择上传文件:<input type="file" name="imgs"  >请输入文件名<input type="text" name="imgName"  ><br/>
    	<!-- 请选择上传文件:<input type="file" name="imgs"  ><br/>
    	请选择上传文件:<input type="file" name="imgs"  ><br/> -->
    	<input type="submit" value="上传">
    </form>
  </body>
</html>
