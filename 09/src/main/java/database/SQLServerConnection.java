package database;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SQLServerConnection {
    public String databaseName;
    public Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;

    public SQLServerConnection() {
    }

    public SQLServerConnection(String database) {
        this.databaseName = database;
    }

    public void getConnection() {
        try {
            if(this.connection == null) {
                FileReader input=new FileReader ("E:\\4 семестр\\Java I\\09\\resources\\db.propetries");
                Properties prop = new Properties();
                prop.load(input);

                String server = prop.getProperty("db.server");
                String security = prop.getProperty("db.security");
                String database = prop.getProperty("db.databaseName");

                String url = String.format("%s%s%s", server, database, security);

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                this.connection = DriverManager.getConnection(url);

                System.out.println("Database " + database + " was successfully connected");
            }
        } catch (Exception e) {
            System.out.println("Error! Unable to connect to database \n");
            e.getMessage();
        }
    }

    public void closeConnection()  {
        try {
            if(this.connection != null) {
                this.connection.close();
                System.out.printf("Disconnected from database %s\n", databaseName);
            }
        } catch (SQLException throwables) {
            System.out.println("Error! Unable to close the connection\n");
            throwables.printStackTrace();
        }
    }

    public void registerUser(String login, String password)
    {
        String hashPassword = Integer.toString(password.hashCode());
        try {
            String query = "insert Users values (?,?,'user')";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, hashPassword);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String login, String password) {
        String hashPassword = Integer.toString(password.hashCode());
        System.out.println (hashPassword);
        String query = "select * from Users where login = ? and password = ?";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, hashPassword);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}