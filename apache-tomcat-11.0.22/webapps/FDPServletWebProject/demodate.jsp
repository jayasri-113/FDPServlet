<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>JSP Demo</title>
</head>
<body>

    <%-- JSP Scriptlet Tag --%>
    <%
        String message = "Welcome to JSP Programming";
    %>

    <h2><%= message %></h2>

    <%-- JSP Expression Tag --%>
    <p>Current Time: <%= new java.util.Date() %></p>

</body>
</html>