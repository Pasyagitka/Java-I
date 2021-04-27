package Filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/secondary.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
        System.out.println ("Filter");
        chain.doFilter (request, response);
    }
}
