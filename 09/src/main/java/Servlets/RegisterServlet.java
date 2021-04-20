package Servlets;

import database.SQLServerConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLServerConnection sqlServerConnection = new SQLServerConnection ();
        sqlServerConnection.getConnection ();
        sqlServerConnection.registerUser (request.getParameter("login"), request.getParameter("password"));
        request.setAttribute("login", request.getParameter("login"));
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        //sqlServerConnection.closeConnection ();
        rd.forward (request, response);
    }
}
