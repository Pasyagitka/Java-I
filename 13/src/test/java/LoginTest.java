import org.junit.Test;
import org.mockito.Mockito;
import pasyagitka.model.CurrentUser;
import pasyagitka.servlets.LoginServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;;

public class LoginTest extends Mockito {
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        String login = "pasyagitka";
        when(request.getParameter("login")).thenReturn(login);
        when(request.getParameter("password")).thenReturn("1234");

        new LoginServlet().doPost(request, response);

        assertEquals(login, CurrentUser.getInstance().getUsername());
    }
}