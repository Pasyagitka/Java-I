package connection;

import java.sql.*;

public class SQLServerConnection implements IConnection {
    private static final String SERVER = "jdbc:sqlserver://localhost;";
    private static final String DATABASE = "database=";
    private static final String SECURITY = "integratedSecurity=true";

    public String databaseName;
    public Connection connection;

    public SQLServerConnection(String database) {
        this.databaseName = database;
    }

    public void GetConnection() {
        try {
            if(this.connection ==null) {//isopened
                this.connection = DriverManager.getConnection(SERVER + DATABASE + databaseName + ";" + SECURITY);
                System.out.println("Database " + databaseName + " was successfully connected");
            }
        } catch (Exception e) {
            System.out.println("Error! Unable to connect to database " + databaseName + "\n");
            e.getMessage();
        }
    }

    public void CloseConnection()  {
        try { //is opened
            if(this.connection ==null) {
                this.connection.close();
                System.out.printf("Disconnected from database %s\n", databaseName);
            }
        } catch (SQLException throwables) {
            System.out.println("Error! Unable to close connection\n");
            throwables.printStackTrace();
        }
    }
}