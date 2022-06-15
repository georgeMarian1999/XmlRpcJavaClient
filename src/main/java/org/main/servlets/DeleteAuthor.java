package org.main.servlets;

import org.main.client.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAuthor", value = "/delete-author")
public class DeleteAuthor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("authorId"));
        Client.deleteAuthor(id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/author-edit-confirmation.jsp");
        requestDispatcher.forward(request, response);
    }
}
