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
          session.invalidate();
        out.println("Admin Logout Successfully");
        
        %>
       <jsp:include page="index.html"></jsp:include>
       </h1>
</body>
</html>