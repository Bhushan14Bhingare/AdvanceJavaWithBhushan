<%@page import="com.bhushan.onlineElectronic.ProductBean"%>
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
         ProductBean pb = (ProductBean) session.getAttribute("product");
        
        
         %>
         <form action="buyProduct" method="post">
    Product Code
    <input type="text" name="bcode" value="<%= pb.getPcode() %>" readonly><br><br>

    Product Name
    <input type="text" name="bname" value="<%= pb.getPname() %>" readonly><br><br>

    Product Company
    <input type="text" name="bcomp" value="<%= pb.getPcomp() %>" readonly><br><br>

    Product Price
    <input type="text" name="bprice" value="<%= pb.getPrice() %>" readonly><br><br>

    Product Quantity
    <input type="text" name="bqty" value="<%= pb.getQty() %>" readonly><br><br>

    Product Required
    <input type="text" name="breq"><br><br>

    <input type="submit" value="BUY">
</form>
        </h1>
</body>
</html>