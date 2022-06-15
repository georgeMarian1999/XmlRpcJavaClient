<%@ page import="org.main.client.Client" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookStore</title>
    <link rel="stylesheet" href="styles/main.css"/>
</head>
<body>
<div>
    <a class="corner-button left-corner-button" href="index.jsp">
        Back to index
    </a>
    <div class="form-wrapper">
        <div>
            <h2>Welcome to the BookStore</h2>
        </div>
        <a href="authors.jsp" >
            See authors
        </a>
        <a href="books.jsp" >
            See books
        </a>

        <%
            out.println(Client.ping());
        %>
    </div>
</div>
</body>
</html>