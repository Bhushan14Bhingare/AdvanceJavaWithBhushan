<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.bhushan.employee.EmpBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <center>
      <h1><u>Employee Data</u></h1>
      
      <h3>
         <%
         ArrayList<EmpBean> al = (ArrayList<EmpBean>) request.getAttribute("list");
            if(al.size() == 0){
            	out.println("Employee table is Empty");
            }
            else{
            	Iterator<EmpBean> itr = al.iterator();
            	
            	while(itr.hasNext()){
            		EmpBean eb = itr.next();
            		
            		out.println(eb+"<br><br>");
            	}
            }
         
         
         %>
         </h3>
         <jsp:include page ="input.html"/>
         
         
      
      
      
      
</body>
</html>