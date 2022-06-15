<%@ page import="org.main.model.Book" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List" %>
<%@ page import="org.main.client.Client" %>
<%@ page import="org.main.model.Author" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: georgemihailescu
  Date: 5/15/2022
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%
            String title = Client.getBookById(Integer.parseInt(request.getParameter("bookId"))).getTitle();
            out.println(title);
        %>
    </title>
    <link rel="stylesheet" href="styles/main.css">

</head>
<body>
    <div class="form-wrapper">
        <form method="get" action="books.jsp" >
            <input class="corner-button left-corner-button" type="submit" value="Back to books table"/>
        </form>
        <div>
            <h2>Edit book details or delete the book</h2>
        </div>
        <form id="edit-book-form" class="form" method="post" action="edit-book">

            <%

                Book book = Client.getBookById(Integer.parseInt(request.getParameter("bookId")));
                Integer authorId = Client.getAuthorById(book.getAuthorId()).getAuthorId();
                out.println("<input type=\"text\" name=\"bookId\" class=\"hidden\" value=\"" + book.getBookId() + "\"/>\n");
                out.println("<label for=\"title\">Name</label>" +
                        "<input type=\"text\" name=\"title\" value=\"" + book.getTitle() + "\"/>\n");
                out.println("<label for=\"year\">Age</label>" +
                        "<input type=\"text\" name=\"year\" value=\"" + book.getYear() + "\"/>\n");

                out.println("<label for=\"description\">Description</label>" +
                        "<input type=\"text\" name=\"description\" value=\"" + book.getDescription() + "\"/>\n");

            %>
            <label for="authors">Author</label>
            <select id="authors" form="edit-book-form" name="authorId">

                    <%
            Gson gson = new Gson();
            List<Author> authors = Client.getAllAuthors();
            for (int i = 0;  i < authors.size();i++) {
                String bookJson = gson.toJson(authors.get(i));
                Author author = gson.fromJson(bookJson, Author.class);
                if (Objects.equals(authorId, author.getAuthorId())) {
                     out.println("<option selected value = \"" + author.getAuthorId() + "\">"+ author.getName() + "</option>");
                }
                else  out.println("<option  value = \"" + author.getAuthorId() + "\">"+ author.getName() + "</option>");
            }
        %>
            <input type="submit" value="Edit book"/>
        </form>

        <form method="post" action="delete-book">
            <%
            out.println("<input type=\"text\" name=\"bookId\" class=\"hidden\" value=\"" + request.getParameter("bookId") + "\"/>\n");
            %>
            <input type="submit" value="Delete book"/>
        </form>
    </div>

</body>
</html>
