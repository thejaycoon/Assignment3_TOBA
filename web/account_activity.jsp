<%-- 
    Document   : account_activity
    Created on : Nov 4, 2016, 1:35:13 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
<html>
    <head>
        <title>Account_activity</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <nav>
         <a href="index.jsp">Home</a> &nbsp;
         <a href="login.jsp">Login</a> &nbsp;
	 <a href="new_customer.jsp">New Customer</a> &nbsp;
         <a href="account_activity.jsp">Account Activity</a> &nbsp;
         <a href="transfer_funds.jsp">Transfer Funds</a> &nbsp;
    </nav>
        <header>Account activity</header> 
        <c:if test="${user != null}">
            <p>Welcome ${user.firstName}</p>
        </c:if>
        <c:if test="${user == null}">
            <p>Not Logged In.</p>
        </c:if>
            <h2>Checking Account:</h2>
            <table>
        <c:forEach var="t" items="${checking.transactions}">
        <tr>
            <td>${t.startingBal}</td>
            <td>${t.finalBalance}</td>
            <td>${t.amountTransferred}</td>
            <td>${t.function}</td>
        </tr>
        </c:forEach> 
            </table>
             <h2>Savings Account:</h2>
            <table>
        <c:forEach var="t" items="${savings.transactions}">
        <tr>
            <td>${t.startingBal}</td>
            <td>${t.finalBalance}</td>
            <td>${t.amountTransferred}</td>
            <td>${t.function}</td>
        </tr>
        </c:forEach> 
            </table>
    </body>
    <%@ include file="/includes/footer.jsp" %>
</html>

