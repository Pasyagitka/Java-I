package pasyagitka.command.commands;

import org.apache.log4j.Logger;
import pasyagitka.command.Command;
import pasyagitka.controller.GoToPageConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAboutPageCommand implements Command {
    private static final Logger logger = Logger.getLogger(GoToAboutPageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(GoToPageConstants.FORWARD_ABOUT_PAGE);
        logger.info("GO TO ABOUT PAGE");
        requestDispatcher.forward(request, response);
    }
}
