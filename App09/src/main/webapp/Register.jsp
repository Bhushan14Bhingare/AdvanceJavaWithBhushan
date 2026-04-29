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
  
  UserBean ub = (UserBean) request.getAttribute("msg");
  out.println(ub.getName()+"<br><br>");
  out.println(ub.getAge()+"<br><br>");
  out.println(ub.getAddress()+"<br><br>");
  out.println(ub.getGender()+"<br><br>");
  out.println(ub.getMarital()+"<br><br>");
  out.println(ub.getQualifcation()+"<br><br>");
  out.println(ub.getCourse()+"<br><br>");
  String str [] = ub.getHobies();
  for(String hobies : str){
	  out.println(hobies+"<br><br>");
  }
  
  
  %>




</h1>
</body>
</html>