package Filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(filterName = "LogFilter", urlPatterns = { "/*"})
public class LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        FileWriter fileWriter = new FileWriter("D:\\4 семестр\\Java I\\09\\resources\\Log.txt", true);
        HttpServletRequest req = (HttpServletRequest) request;
        fileWriter.write(req.getMethod() + " - " + LocalDateTime.now() + " - " + ((HttpServletRequest) request).getServletPath() + "\r\n");
        fileWriter.flush();
        chain.doFilter (request, response);
    }
}
