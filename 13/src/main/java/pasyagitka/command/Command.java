package pasyagitka.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    /**
     * The method execute input command
     *
     * @param request {@link HttpServletRequest} client request
     * @param response {@link HttpServletResponse} server response
     * @throws ServletException extends {@link Exception}
     * @throws IOException extends {@link Exception}
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
