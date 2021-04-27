package controller;

import by.malinka.service.ServletServer;
import by.malinka.users.CurrentUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register-servlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletServer servletServer = ServletServer.getInstance();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        switch (servletServer.RegisterUser(login, password))
        {
            case (0) : {
                CurrentUser.getInstance().setCurrentUser(login);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                break;
            }
            case (1) :
            {
                request.setAttribute("message", "User with the same name is already exists");
                getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
                break;
            }
        }
    }
}