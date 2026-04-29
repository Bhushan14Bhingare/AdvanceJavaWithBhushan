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
          
         CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
         
         if(cb != null){
        	 out.println("Welecome "+cb.getFname()+" to store <br><br>");
         }
         else{
        	 out.println("Session expired or not logged in");
         }
         
         %>
         <a href = "View2">ViewProduct</a> <br><br>     
          <a href = "Logout">Logout</a>  <br><br>
         </h1>
</body>
</html>