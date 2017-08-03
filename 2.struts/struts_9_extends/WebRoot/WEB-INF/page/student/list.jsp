<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- 如果使用命名空间,建议使用如下配置
  		这行代码表示将页面内的所有请求资源,以项目的根目录开始进行请求
  		跳出命名空间
  	 -->
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
  	<img src="1.jpg">
    这是列表页面
    
    <table>
    	<tr>
    		<td>ID</td>
    		<td>NAME</td>
    		<td>MOBILE</td>
    		<td>AGE</td>
    		<td>ADDRESS</td>
    		<td>OP</td>
    	</tr>
    	<c:forEach items="${list }" var="stu">
    	
    	<tr>
    		<td>${stu.id }</td>
    		<td>${stu.name }</td>
    		<td>${stu.mobile }</td>
    		<td>${stu.age }</td>
    		<td>${stu.address }</td>
    		<td><a href="student/delete.action?id=${stu.id }">删除</a></td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
