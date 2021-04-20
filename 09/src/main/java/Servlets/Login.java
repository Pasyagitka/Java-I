package Servlets;

import database.SQLServerConnection;
import database.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLServerConnection sqlServerConnection = new SQLServerConnection ();
        sqlServerConnection.getConnection ();
        RequestDispatcher rd;
        if (sqlServerConnection.loginUser(request.getParameter("login"), request.getParameter("password")))
        {
           request.setAttribute("login", request.getParameter("login"));
           rd = request.getRequestDispatcher("login.jsp");

            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
            String dateString = formatForDateNow.format(date);

            Cookie cookie1 = new Cookie("user", request.getParameter("login"));
            Cookie cookie2 = new Cookie("lasttime", dateString);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        }
        else
        {
           rd = request.getRequestDispatcher("index.jsp");
        }

        //sqlServerConnection.closeConnection ();
        rd.forward (request, response);
    }
}
