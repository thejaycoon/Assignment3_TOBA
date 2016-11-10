<%-- 
    Document   : password_reset
    Created on : Nov 5, 2016, 11:13:22 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <title>Password Reset</title>
        <link rel="stylesheet" href="Styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <nav>
         <a href="index.jsp">Home</a> &nbsp;
         <a href="login.jsp">Login</a> &nbsp;
	 <a href="new_customer.jsp">New Customer</a> &nbsp;
    </nav>
        <h1>Need to reset password?</h1>
    <p>Enter user name and type new password.</p>
    <form action="ResetPasswordServlet" method="post">
        <label class="pad_top">Password:</label>
        <input type="text" name="password" required><br>
        <input type="hidden" name="action" value="${user.password}">
        <input type="hidden" name="action" value="add">
        <label>&nbsp;</label> <br>
        <input type="submit" value="Login" class="margin_left">
    </form><br>
    
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>