<%-- 
    Document   : transfer_funds
    Created on : Nov 17, 2016, 3:44:14 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!DOCTYPE html>
<html>
    <head>
        <title>Transfer Funds</title>
        <link rel="stylesheet" href="Styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <nav>
         <a href="index.jsp">Home</a> &nbsp;
         <a href="login.jsp">Login</a> &nbsp;
	 <a href="new_customer.jsp">New Customer</a> &nbsp;
         <a href="account_activity.jsp">Account Activity</a> &nbsp;
         <a href="account_activity.jsp">Transfer Funds</a> &nbsp;
    </nav>
    <h1>Transfer Funds</h1>
    <p>Checking account balance: ${checking.startingBal}</p>
    <p>Savings account balance: ${savings.startingBal}</p>
    <form action="TransactionServlet" method="post">
        <label class="pad_top">Specify Amount to Transfer:</label>
        <input type="text" name="amount" required><br>
        <input type="submit" value="Submit Transfer" class="margin_left">
    </form><br>
    
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>
