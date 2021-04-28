package Servlets;

import java.io.*;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class TimeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss a zzz");
        String dateString = "Текущая дата " + formatForDateNow.format(date);

        StringBuffer requestURL = req.getRequestURL();
        String requestType = req.getMethod();
        String address = req.getRemoteAddr();
        String name = InetAddress.getLocalHost().getHostName();
        String protocol = req.getProtocol();
        String headers = "";
        Enumeration headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            headers+=(String)headerNames.nextElement()+", ";
        }
        req.setAttribute("headers",headers);
        req.setAttribute("time", dateString);
        req.setAttribute("p", protocol);
        req.setAttribute("address",address);
        req.setAttribute("name",name);
        req.setAttribute("requestType",requestType);
        req.setAttribute("requestURL",requestURL);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("time.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void destroy() {
    }
}