<%-- 
    Document   : account_activity
    Created on : Nov 4, 2016, 1:35:13 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<c:if test="${user.username + user.password != null}">
    <p>Welcome ${user.firstName + user.lastName}</p>
</c:if>
<c:if test="${user.username + user.password == null}">
    <p>Not Logged In.</p>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <title>Account_activity</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>Account activity</header> 
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>

