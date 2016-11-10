<%-- 
    Document   : new_customer
    Created on : Nov 4, 2016, 1:22:29 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <title>New_customer</title>
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
        <h1>Want to become a Titan member?</h1>
        <p>Enter personal information and join today. All fields required.</p><br>
    <form action="NewCustomerServlet" method="post">
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstname" required><br>
        <label class="pad_top">Last Name:&nbsp;</label>
        <input type="text" name="lastname" required><br>
        <label class="pad_top">Phone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="phone" required><br>
        <label class="pad_top">Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="address" required><br>
        <label class="pad_top">City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="city" required><br>
        <label class="pad_top">State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="state" required><br>
        <label class="pad_top">Zip:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="zip" required><br>
        <label class="pad_top">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="email" required><br>
        <label>&nbsp;</label><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Join Now" class="margin_left">
    </form><br>
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>
