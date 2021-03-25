package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class SQLServerConnection implements IConnection {

    public String databaseName;
    public Connection connection;

    public SQLServerConnection(String database) {
        this.databaseName = database;
    }

    public void GetConnection() {
        try {
            if(this.connection == null) {
                InputStream input = new FileInputStream("resources/db.properties");
                Properties prop = new Properties();
                prop.load(input);

                String server = prop.getProperty("db.server");
                String security = prop.getProperty("db.security");

                String url = String.format("%s;database=%s;%s", server, databaseName, security);
                this.connection = DriverManager.getConnection(url);
                System.out.println("Database " + databaseName + " was successfully connected");
            }
        } catch (Exception e) {
            System.out.println("Error! Unable to connect to database " + databaseName + "\n");
            e.getMessage();
        }
    }

    public void CloseConnection()  {
        try {
            if(this.connection != null) {
                this.connection.close();
                System.out.printf("Disconnected from database %s\n", databaseName);
            }
        } catch (SQLException throwables) {
            System.out.println("Error! Unable to close connection\n");
            throwables.printStackTrace();
        }
    }
}