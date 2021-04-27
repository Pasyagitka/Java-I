package controller;

import by.malinka.medcenter.Med;
import by.malinka.service.ServletServer;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Med med = ServletServer.getInstance().getMedByName(
                request.getParameter("name")
        );
        logger.info(med);
        request.setAttribute("med", med);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        Med med = new Med(request.getParameter("name"),
                Integer.parseInt(request.getParameter("price")),
                Date.valueOf(request.getParameter("date")));

        logger.info(med);
        ServletServer.getInstance().updateProductByName(med);
        List<Med> meds = ServletServer.getInstance().getMedsFromDB().getMeds();
        request.setAttribute("meds", meds);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
