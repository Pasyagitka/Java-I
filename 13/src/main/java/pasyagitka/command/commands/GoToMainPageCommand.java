package pasyagitka.command.commands;

import org.apache.log4j.Logger;
import pasyagitka.command.Command;
import pasyagitka.controller.GoToPageConstants;
import pasyagitka.model.Record;
import pasyagitka.database.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToMainPageCommand implements Command {
    private static final Logger logger = Logger.getLogger(GoToMainPageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Record> recordList = DatabaseConnection.getInstance().getRecordsFromDB().getRecordList();
        request.setAttribute("recordList", recordList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(GoToPageConstants.FORWARD_MAIN_PAGE);
        logger.info("GO TO MAIN PAGE");
        requestDispatcher.forward(request, response);
    }
}
