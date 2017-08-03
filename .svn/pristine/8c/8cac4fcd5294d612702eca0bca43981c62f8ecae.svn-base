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
    	<form action="add.action" method="post">
    	
    		姓名<input type="text" name="name"><br/>
    		账号<input type="text" name="username"><br/>
    		密码<input type="password" name="password"><br/>
    		年龄<input type="text" name="age"><br/>
    		电话<input type="text" name="tel"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	<hr/>
    	
    	<form action="delete.action" method="post">
    		
    		id<input type="text" name="ids1"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	
    	<hr/>
    	<form action="delete.action" method="post">
    		
    		id1<input type="text" name="ids1"><br/>
    		id2<input type="text" name="ids1"><br/>
    		id3<input type="text" name="ids1"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	<hr/>
    	<form action="delete.action" method="post">
    		
    		id1<input type="text" name="ids2"><br/>
    		id2<input type="text" name="ids2"><br/>
    		id3<input type="text" name="ids2"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	
    	<a href="delete.action?ids2=1&ids2=2&ids2=3">get</a>
    	<hr/>
    	<form action="delete.action" method="post">
    		
    		id<input type="text" name="id"><br/>
    		name<input type="text" name="name"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	
    	
    	
    	<hr/>
    	<form action="update.action" method="post">
    		问题1
    		<input type="text" name="ques[0]"><br/>
    		<input type="text" name="answ[0]"><br/>
    		问题2
    		<input type="text" name="ques[1]"><br/>
    		<input type="text" name="answ[1]"><br/>
    		问题3
    		<input type="text" name="ques[2]"><br/>
    		<input type="text" name="answ[2]"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	<hr/>
    	<form action="update.action" method="post">
    		问题1
    		<input type="text" name="map.key1"><br/>
    		问题2
    		<input type="text" name="map.key2"><br/>
    		问题3
    		<input type="text" name="map.key3"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
    	
    	<hr/>
    	<form action="update.action" method="post">
    		问题1
    		<input type="text" name="list1[0].question"><br/>
    		<input type="text" name="list1[0].answer"><br/>
    		问题2
    		<input type="text" name="list1[1].question"><br/>
    		<input type="text" name="list1[1].answer"><br/>
    		问题3
    		<input type="text" name="list1[2].question"><br/>
    		<input type="text" name="list1[2].answer"><br/>
    		
    		<input type="submit" value="注册">
    	</form>
  </body>
</html>
