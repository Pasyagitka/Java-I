package pasyagitka.controller;

import org.apache.log4j.Logger;
import pasyagitka.controller.command.Command;
import pasyagitka.controller.command.CommandProvider;
import pasyagitka.controller.message.GoToPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private final static Logger logger = Logger.getLogger(Controller.class);
    private final static String COMMAND = "command";

    private static final long serialVersionUID = 1L;

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    /**
     * The override method doGet receive get client requests
     *
     * @param request {@link HttpServletRequest} client request
     * @param response {@link HttpServletResponse} server response
     * @throws ServletException extends {@link Exception}
     * @throws IOException extends {@link Exception}
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * The override method doPost receive post client requests
     *
     * @param request {@link HttpServletRequest} client request
     * @param response {@link HttpServletResponse} server response
     * @throws ServletException extends {@link Exception}
     * @throws IOException extends {@link Exception}
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * The method process get doGet and doPost request and response requests and process them
     *
     * @param request {@link HttpServletRequest} client request
     * @param response {@link HttpServletResponse} server response
     * @throws ServletException extends {@link Exception}
     * @throws IOException extends {@link Exception}
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(COMMAND);
        if (name != null) {
            Command command = provider.takeCommand(name);
            command.execute(request, response);
        } else {
            logger.info("No command parameter");
            response.sendRedirect(GoToPage.REDIRECT_ERROR_PAGE);
        }
    }
}
