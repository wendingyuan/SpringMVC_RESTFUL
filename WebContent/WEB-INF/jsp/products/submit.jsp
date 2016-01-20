<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<body>
    <form action="<%=basePath%>/api/products/info" method="post">
         <input type="text" name="pid"/> 
         <input type="text" name="pname"/> 
         <input type="submit"/>
    </form>
</body>