<%-- 
    Document   : index
    Created on : Nov 4, 2016, 1:18:56 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>        
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
        <header> 
            <%@ include file="/includes/header.html" %>
            <h1> Titan Online Banking </h1>
        <section> 
            <p> Welcome to Titan Online Banking. If you are already a member, please log in.
                If you want to become a member, please visit our New Customer Sign Up page.</p>
        </section>
            <section>
                <a href="login.jsp">Member Login</a>
            </section>
        </header>
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>
