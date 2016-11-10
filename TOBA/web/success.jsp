<%-- 
    Document   : success
    Created on : Nov 4, 2016, 1:30:06 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <title>Success</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <h1>Congratulations! ${sessionScope.user.firstName}</h1>
            <h2>Your account has been successfully created.</h2> 
        </header>
            <h3>The information you entered is:</h3>
            <label>First Name:</label>
            <span>${user.firstName}</span><br>
            <label>Last Name:</label>
            <span>${user.lastName}</span><br>
            <label>Phone:</label>
            <span>${user.phone}</span><br>
            <label>Address:</label>
            <span>${user.address}</span><br>
            <label>City:</label>
            <span>${user.city}</span><br>
            <label>State:</label>
            <span>${user.state}</span><br>
            <label>Zip Code:</label>
            <span>${user.zipCode}</span><br>
            <label>Email:</label>
            <span>${user.eMail}</span><br>
            <label>Username:</label>
            <span>${user.userName}</span><br>
            <label>Password:</label>
            <span>${user.password}</span><br>
            
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>
