package pasyagitka.servlets;


import org.apache.log4j.Logger;
import pasyagitka.Model.Record;
import pasyagitka.database.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Record record = DatabaseConnection.getInstance().getRecordsByName(
                request.getParameter("name")
        );
        logger.info(record);
        request.setAttribute("record", record);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Record r = new Record(request.getParameter("name"),
                Long.parseLong(request.getParameter("phonenumber")),
                request.getParameter("email"));

        logger.info(r);
        DatabaseConnection.getInstance().updateRecordsByName(r);
        List<Record> records = DatabaseConnection.getInstance().getRecordsFromDB().getRecordList();
        request.setAttribute("recordList", records);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
