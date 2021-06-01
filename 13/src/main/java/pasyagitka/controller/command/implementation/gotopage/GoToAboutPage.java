package pasyagitka.controller.command.implementation.gotopage;

import org.apache.log4j.Logger;
import pasyagitka.controller.command.Command;
import pasyagitka.controller.message.GoToPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAboutPage implements Command {
    private static final Logger logger = Logger.getLogger(GoToAboutPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(GoToPage.FORWARD_ABOUT_PAGE);
        logger.info("Forward to main page");
        requestDispatcher.forward(request, response);
    }
}
