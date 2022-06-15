package org.main.servlets;

import org.main.client.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editAuthor", value = "/edit-author")
public class EditAuthor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("authorId"));
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Client.editAuthor(id, name, age);

        request.getRequestDispatcher("/author-edit-confirmation.jsp").forward(request, response);
    }
}
