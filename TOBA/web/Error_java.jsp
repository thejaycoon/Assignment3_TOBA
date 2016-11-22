<%-- 
    Document   : Error_java
    Created on : Oct 20, 2016, 3:38:22 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error_Java</title>
    </head>
    <body>
        <h1>Java Error</h1>
        <p>Sorry, java has thrown an exception.</p>
        <p>To continue, click the back button.</p>
        <h2>Details</h2>
        <p>Type: {pageContext.exception["class"]}</p>
        <p>Message: {pageContext.exception.message}</p>
    </body>
</html>
