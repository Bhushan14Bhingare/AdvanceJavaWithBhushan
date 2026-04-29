<%@ page import="com.bhushan.onlineElectronic.ProductBean" %>
<%@ page import="com.bhushan.onlineElectronic.AdminBean" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
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
       AdminBean ab = (AdminBean) session.getAttribute("abean");
        ProductBean pb =  (ProductBean) request.getAttribute("p_bean");
        out.println(ab.getFname()+" below is the data is available to Edit");
        
       %> 
       <form action = "update" method = post>
       
       Product Price <input type = "text" name = "pprice" value = "<%=pb.getPrice() %>"><br><br>
       Product Quantity <input type = "text" name = "pqty" value = "<%= pb.getQty() %>"><br><br>
       
       <input type = "hidden" name = "pcode" value = "<%= pb.getPcode() %>">
       <input type = "submit" value = "Update">
       
       
       </form>
       </h1>
</body>
</html>