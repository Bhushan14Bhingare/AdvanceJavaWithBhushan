<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bhushan.onlineElectronic.AdminBean" %>
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
       
       String data = (String)request.getAttribute("msg");
      
       out.println(data+"<br><br>"); 
       %>
        <a href = "AddProduct.html">AddProduct</a><br><br>      
          <a href = "View1">ViewProduct</a> <br><br>     
          <a href = "Logout">Logout</a>  <br><br>
</body>
</html>