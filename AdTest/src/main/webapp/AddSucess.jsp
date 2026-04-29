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
      String data = (String) request.getAttribute("msg");
      out.println(data);
      %>
      <a href = "index.html"> Add Product</a>
      <a href = "Update.html" >Update Product</a>
      <a href = "View"> View Product</a>
      
      </h1>
</body>
</html>