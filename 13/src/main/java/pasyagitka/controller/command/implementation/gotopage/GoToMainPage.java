package pasyagitka.controller.command.implementation.gotopage;

import org.apache.log4j.Logger;
import pasyagitka.controller.command.Command;
import pasyagitka.controller.message.GoToPage;
import pasyagitka.Model.Record;
import pasyagitka.database.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToMainPage implements Command {
    private static final Logger logger = Logger.getLogger(GoToMainPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Record> recordList = DatabaseConnection.getInstance().getRecordsFromDB().getRecordList();
        request.setAttribute("recordList", recordList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(GoToPage.FORWARD_MAIN_PAGE);
        logger.info("Forward to main page");
        requestDispatcher.forward(request, response);
    }
}
