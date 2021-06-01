package pasyagitka.servlets;

import pasyagitka.Model.Record;
import pasyagitka.database.DatabaseConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addServlet", value = "/add-servlet")
public class AddServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseConnection servletServer = DatabaseConnection.getInstance();
        servletServer.addRecordsToDB(request.getParameter("name"),
                Long.parseLong(request.getParameter("phonenumber")),
                request.getParameter("email"));
        List<Record> recordList = DatabaseConnection.getInstance().getRecordsFromDB().getRecordList();
        request.setAttribute("recordList", recordList);
        logger.info(recordList);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
