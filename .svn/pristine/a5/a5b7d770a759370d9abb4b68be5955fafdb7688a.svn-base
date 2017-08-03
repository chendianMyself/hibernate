<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>

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
  	<s:debug></s:debug>
  	<s:fielderror></s:fielderror>
    <form action="student/add.action" method="post">
    	<table>
	    	<tr>
	    		<td>NAME</td>
	    		<td><input type="text" name="student.name" value="${student.name }"> ${errors.student.name }</td>
	    	</tr>
	    	<tr>
	    		<td>MOBILE</td>
	    		<td><input type="text" name="student.mobile" value="${student.mobile }"> ${errors.mobile }</td>
	    	</tr>
	    	<tr>
	    		<td>AGE</td>
	    		<td><input type="text" name="student.age" value="${student.age }"> ${errors.age }</td>
	    	</tr>
	    	<tr>
	    		<td>ADDRESS</td>
	    		<td><input type="text" name="student.address" value="${student.address }"></td>
	    	</tr>
	    	<tr>
	    		<td colspan="2"><input type="submit" value="添加"></td>
	    	</tr>
	    </table>
    </form>
  </body>
</html>
