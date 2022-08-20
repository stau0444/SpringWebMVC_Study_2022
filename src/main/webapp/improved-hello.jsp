<%--@elvariable id="userName" type="com.study.springmvc_2022.ImprovedHelloServlet"--%>
<%--@elvariable id="servletName" type="com.study.springmvc_2022.ImprovedHelloServlet"--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>간단 서블릿 + JSP 개발</title>
</head>
<body>
<h1>${userName} 님 안녕하세요</h1>
<h1>저는 ${servletName} 입니다.</h1>
</body>
</html>