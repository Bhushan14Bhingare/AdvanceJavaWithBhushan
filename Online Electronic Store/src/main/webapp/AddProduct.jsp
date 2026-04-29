<%@page import="com.bhushan.onlineElectronic.AdminBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	   <h1>
	   		<%
	   		AdminBean abean =(AdminBean)session.getAttribute("abean");
	   		
	   		String data =(String)request.getAttribute("msg");
	   		out.println(data+ " MR. "+abean.getFname()+"<br><br>");
	   		
	   		%>
	   		
	 	<a href="AddProduct.html">Add Products</a> <br><br>
	 		<a href="view">View Products</a> <br><br>
	 			<a href="logout">Logout</a><br><br>
	 			
	   </h1>
</body>
</html>