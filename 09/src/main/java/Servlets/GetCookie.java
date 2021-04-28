package Servlets;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet", value = "/cookieServlet")
public class GetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        for (Cookie cookie: cookies) {
            out.println("<h3>" + cookie.getName() + " " + cookie.getValue() + "</br>");
        }
        out.println("</body></html>");
    }
}
