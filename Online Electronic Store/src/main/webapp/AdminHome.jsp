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
           AdminBean abean = (AdminBean) session.getAttribute("abean");
           
            if (abean != null) {
             out.println("Welcome " + abean.getFname()+"<br><br>");
             } 
            else 
            { 
               out.println("Session expired or not logged in");
             }
          %>
           <a href = "AddProduct.html">AddProduct</a><br><br>      
          <a href = "View1">ViewProduct</a> <br><br>     
          <a href = "Logout">Logout</a>  <br><br>
         </h1>         
         
         
</body>
</html>