<%-- 
    Document   : login
    Created on : Nov 4, 2016, 1:25:14 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
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
        <h1>Already a Member?</h1>
    <p>Enter user name and password.</p>
    <form action="LoginServlet" method="post">
        <label class="pad_top">Username:</label>
        <input type="text" name="username" required><br>
        <label class="pad_top">Password:</label>
        <input type="text" name="password" required><br>
        <input type="hidden" name="action" value="add">
        <label>&nbsp;</label> <br>
        <input type="submit" value="Login" class="margin_left">
    </form><br>
    <section>
        <a href="new_customer.jsp">New customer sign up</a><br>
                <a href="password_reset.jsp">Password reset</a> 
                
    </section>
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>
