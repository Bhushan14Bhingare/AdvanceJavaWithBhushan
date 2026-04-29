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
       ArrayList<ProductBean> al =  (ArrayList<ProductBean>) session.getAttribute("productList");
       
       if(al.size() == 0){
    	       out.println("Product are not available in the Inventory");
       }
       else{
    	   out.println("Hello Mr "+ab.getFname()+" these are your Product Details<br><br>");
    	   Iterator<ProductBean> itr = al.iterator();
    	   while(itr.hasNext()){
    		   ProductBean pb = itr.next();
    		   out.println(pb.getPcode()+" "+pb.getPname()+" "+pb.getPcomp()+" "+pb.getPrice()+" "+pb.getQty()+" "
    		   +"<a href = 'edit?pcode="+pb.getPcode()+"'>Edit</a>"+" "
    		   +"<a href = 'delete?pcode="+pb.getPcode()+"'>Delete</a>"+"<br><br>");
    	   }
       }
        %>
        </h1>
</body>
</html>