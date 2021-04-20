package TwoServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "From First GET");

        //перенаправить-отправить запрос на другой сервлет (сервлет на сервлет) и не отправлять запрос другому браузеру/клиенту.
        request.getRequestDispatcher("/SecondServlet").forward(request, response);
        //Переадресация redirect возвращает запрос браузеру с сервера, а затем повторно отправит запрос на сервер из браузера.
        //response.sendRedirect("/SecondServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "From First POST");
        request.getRequestDispatcher("/SecondServlet").forward(request, response);
    }


}
