import org.junit.Test;
import org.mockito.Mockito;
import pasyagitka.model.Record;
import pasyagitka.database.DatabaseConnection;
import pasyagitka.servlets.AddServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddTest extends Mockito {
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        String testName = "Test";
        long testPhone = 5634337;
        String testEmail = "TestTestTest@gmail.ru";

        when(request.getParameter("name")).thenReturn(testName);
        when(request.getParameter("phonenumber")).thenReturn(Long.toString(testPhone));
        when(request.getParameter("email")).thenReturn(testEmail);

        new AddServlet().doPost(request, response);

        List<Record> records = DatabaseConnection.getInstance().getRecordsFromDB().getRecordList();
        boolean result = false;
        for (Record record:records) {
            if (record.name.equals(testName) && record.email.equals(testEmail) && record.phonenumber == testPhone) {
                result = true;
                break;
            }
        }
        assertTrue(result);
    }
}
