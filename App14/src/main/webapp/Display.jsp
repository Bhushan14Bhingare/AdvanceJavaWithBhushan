<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <h1>
        <%  pageContext.setAttribute("fname","Java is awesome"); %>
        <c:set var = "name" value ="${param.uname}"/>
        WELCOME : <c:out value="${name}"></c:out>
        <c.set var = "a" value = "${applictionScope.a}"/>
        <c.set var = "b" value = "${session.b}"/>
        <c.set var = "c" value = "${request.c}"/>
        <c.set var = "d" value = "${pageScope.fname}"/>
        
        ContextVal : <c:out value="${a}"></c:out>
        SessionVal : <c:out value="${b}"></c:out>
        RequsetVal : <c:out value="${c}"></c:out>
        PageVal    : <c:out value="${d}"></c:out>
        
        </h1>
</body>
</html>