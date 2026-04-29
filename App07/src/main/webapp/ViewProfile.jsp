<%@page import="com.bhushan.registration.UserBean"%>
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
        String name = (String) request.getAttribute("user_name");
       UserBean ub = (UserBean) application.getAttribute("userBean");
       
       out.println("This is session belongs to "+name+"<br><br>");
       out.println("<u>Profile Details</u><br><br>");
       
       String pass = ub.getU_pwd();
       String encryptPass = pass.substring(0,1)+"*****"+pass.substring(pass.length()-1);
         
       out.println(ub.getU_name()+"  "+ encryptPass+"  "+ub.getU_fname()+"  "+ub.getU_lname()+"  "+ub.getU_mail()+"  "+ub.getU_phone()+"<br><br>");
       
       %>
   
   <a href="edit">Edit Profile</a>
   <a href="logout">Logout</a>
   
   </h1>  
</body>
</html>