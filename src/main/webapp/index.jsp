<%@ page import="org.main.client.Client" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<%
    String ping = Client.ping();
%>
<body>
<h1><%= ping %>
</h1>
<br/>
<a class="corner-button" href="home.jsp">Home page</a>
</body>
</html>