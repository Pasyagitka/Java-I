package connection;

import java.sql.*;

public class SQLServerConnection implements IConnection {
    private static final String SERVER = "jdbc:sqlserver://localhost;";
    private static final String DATABASE = "database=";
    private static final String SECURITY = "integratedSecurity=true";
    public static Statement CONNECTION;

    public static Connection GetConnection(String database) {
        try {
            Connection connection = DriverManager.getConnection(SERVER + DATABASE + database + ";" + SECURITY);
            CONNECTION = connection.createStatement();
            System.out.println("Database " + database + " was successfully connected");
            return connection;
        } catch (Exception e) {
            System.out.println("Error! Unable to connect to database " + database + "\n");
            e.getMessage();
        }
        return null;
    }



    public static void CloseConnection(String database)  {
        try { //TODO check is opened
            CONNECTION.close();
            System.out.println("Disconnected");
        } catch (SQLException throwables) {
            System.out.println("Error! Unable to close connection\n");
            throwables.printStackTrace();
        }
    }
}