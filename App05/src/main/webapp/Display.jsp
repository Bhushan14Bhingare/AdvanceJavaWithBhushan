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
                String p_name = request.getParameter("pname");
                String p_id = request.getParameter("pid");
                String p_qty = request.getParameter("pqty");
                String p_price = request.getParameter("price");
                out.println("Product Name : "+p_name+"<br>");
                out.println("Product Name : "+p_id+"<br>");
                out.println("Product Name : "+p_qty+"<br>");
                out.println("Product Name : "+p_price+"<br>");
                %>
                 
          </h1>
</body>
</html>