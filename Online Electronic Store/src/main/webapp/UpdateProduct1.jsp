<%@page import="com.bhushan.onlineElectronic.CustomerBean"%>


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
    
     CustomerBean abean = (CustomerBean) session.getAttribute("cbean");
     String data = (String)request.getAttribute("msg");
     out.println("Hello "+abean.getFname()+"<br><br>");
     out.println("You have charged Rs "+data+"<br><br>");
     out.println("Your order is placed successfully<br><br>"); 
     %>
     
   
     </h1>
     <a href = "View2">ViewProduct</a> <br><br>     
          <a href = "Logout">Logout</a>  <br><br>
</body>
</html>