package controller;


import medcenter.Med;
import org.apache.log4j.Logger;
import service.ServletServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "addServlet", value = "/add-servlet")
public class AddServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletServer servletServer = ServletServer.getInstance();
        servletServer.addMedToDB(request.getParameter("name"),
                Integer.parseInt(request.getParameter("price")) , Date.valueOf(request.getParameter("date")));
        List<Med> meds = ServletServer.getInstance().getMedsFromDB().getMeds();
        request.setAttribute("meds", meds);
        logger.info(meds);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
