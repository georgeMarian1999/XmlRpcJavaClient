<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.main.client.Client" %>
<%@ page import="org.main.model.Author" %>
<html>
<head>
    <title>Authors</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<%
  String keyword = request.getParameter("search-parameter");
  List<Author> authors;
  Gson gson = new Gson();
  if (keyword != null) {
      authors = Client.getAuthorsBySearch(keyword);
  }
  else authors = Client.getAllAuthors();

%>
<body>
<a class="left-corner-button corner-button" href="home.jsp">
  Home
</a>
<a class="right-corner-button corner-button" href="author-add.jsp">
 Add author
</a>
  <div class="form-wrapper">
    <h2>Search all authors with the name</h2>
    <form method="get" action="authors.jsp" target="_parent">
      <input type="text" name="search-parameter"/>
      <input type="submit"/>
    </form>
    <form method="get" action="authors.jsp" target="_parent">
      <input type="submit" value="Reset"/>
    </form>
  </div>

  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Age</th>
    </tr>
    <%
      if (authors == null) {
        authors = new ArrayList<>();
      }
      for (int i = 0; i < authors.size(); i++
           ) {
        // For the PHP server connection
        // arrays in PHP convert the objects in them to HashMap
        String authorJson = gson.toJson(authors.get(i));
        Author author = gson.fromJson(authorJson, Author.class);
        out.println("<tr>" +
                "<td>\n" +
                "                    <form action=\"author-detail.jsp\" method=\"get\">\n" +
                "                        <input type=\"text\" name=\"authorId\" class=\"hidden\" value=\"" + author.getAuthorId() + "\" />\n" +
                "                        <input type=\"submit\" value=\"" + author.getAuthorId() + "\">\n" +
                "                    </form>\n" +
                "                </td>" +
                "<td>" +
                author.getName() +
                "</td>" +
                "<td>" +
                author.getAge() +
                "</td>" +
                "</tr>");
      }
    %>
  </table>


</body>
</html>
