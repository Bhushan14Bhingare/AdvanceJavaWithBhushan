<%@page import="java.util.Iterator"%>
<%@page import="com.bhshan.product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
         ArrayList<ProductBean> al = (ArrayList<ProductBean>) request.getAttribute("productList");
        
        out.println(al);
        
        %>
</body>
</html>