package pasyagitka.controller;

import pasyagitka.RecordsList.Record;
import pasyagitka.database.DatabaseConnection;
import pasyagitka.users.CurrentUser;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loggingServlet", value = "/logging-servlet")
public class LoginServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(LoginServlet.class);

    public boolean isLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            logger.info(session.getAttribute("user").toString());
            return true;
        } else {
            logger.info(false);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DatabaseConnection servletServer = DatabaseConnection.getInstance();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        boolean isLogged = servletServer.LoginUser(login, request.getParameter("password"));
        HttpSession session = request.getSession(true);
        RequestDispatcher rd;
        if (isLogged) {
            CurrentUser.getInstance().setCurrentUser(login);
            session.setAttribute("user", CurrentUser.getInstance());
            List<Record> recordList = DatabaseConnection.getInstance().getRecordsFromDB().getRecordList();
            request.setAttribute("recordList", recordList);
            logger.info(recordList);
            rd = request.getRequestDispatcher("welcome.jsp");
        } else {
            request.setAttribute("message", "Wrong login or password");
            rd = request.getRequestDispatcher("index.jsp");
        }
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isLogged(request, response)) {
            return;
        }
        this.doPost(request, response);
    }
}
