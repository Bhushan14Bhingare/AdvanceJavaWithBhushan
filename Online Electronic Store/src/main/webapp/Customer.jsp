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
     
    String data = (String) request.getAttribute("abean");
    out.println(data+"<br><br>");
    
    %>
    
    <a href="AdminLogin.html">Admin Login</a><br><br>
        <a href="CustomerLogin.html">Customer Login</a>
    
    </h1>
</body>
</html>