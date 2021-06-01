package meow.pasyagitka;

import meow.pasyagitka.model.Record;
import meow.pasyagitka.model.User;
import meow.pasyagitka.database.DAOFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZeiPrintTable extends TagSupport {
    private String tableName;
    private Connection connection;

    @Override
    public int doStartTag() throws JspException {
        DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Java10","JAVA", "JAVA");
        connection = daoFactory.getConnection();

        JspWriter out = pageContext.getOut();

        if (tableName.equals("Records")) {
            String sql = "select * from Records;";
            List<Record> records = new ArrayList<>();
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Record med = new Record(
                            rs.getInt("Id"),
                            rs.getString("name"),
                            rs.getLong("phonenumber"),
                            rs.getString("email")
                    );
                    records.add(med);
                }

                try {
                    out.print("<br/>");
                    out.print("<table>");
                    out.print("<tr><th>Name</th><th>Phone</th><th>Email</th></tr>");
                    for (Record record : records) {
                        out.print("<tr><th>" + record.getName() + "</th><th>" + record.getPhoneNumber() + "</th><th>" + record.getEmail() + "</th></tr>");
                    }
                    out.print("<table/>");
                    out.print("<br/>");
                } catch (IOException e) {
                    throw new JspException(e);
                }

                return EVAL_BODY_INCLUDE;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (tableName.equals("Users")) {
            String sql = "select * from Users;";
            List<User> users = new ArrayList<>();
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setRoleId(rs.getString("role"));
                    users.add(user);
                }

                try {
                    out.print("<br/>");
                    out.print("<table>");
                    out.print("<tr><th>Id</th><th>Login</th><th>Password</th><th>Role</th></tr>");
                    for (User user : users) {
                        out.print("<tr><th>" + user.getId() + "</th><th>" + user.getLogin() + "</th><th>" + user.getPassword() + "</th><th>" + user.getRole() + "</th></tr>");
                    }
                    out.print("<table/>");
                    out.print("<br/>");
                } catch (IOException e) {
                    throw new JspException(e);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return EVAL_BODY_INCLUDE;
        }
        return EVAL_BODY_INCLUDE;
    }

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
