package pasyagitka.database;

import pasyagitka.Model.Record;
import pasyagitka.Model.RecordsList;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    ResultSet rs;
    PreparedStatement stmt;
    public final Connection connection;

    public static DatabaseConnection getInstance()
    {
        if ( instance != null) return instance;
        instance = new DatabaseConnection();
        return instance;
    }
    private DatabaseConnection()
    {
        DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Java10;integratedSecurity=true");
        connection = daoFactory.getConnection();
    }
    public RecordsList getRecordsFromDB()
    {
        String sql = "select * from Records;";
        RecordsList recordList = RecordsList.getInstance();
        recordList.clear();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            rs = stm.executeQuery();
            while (rs.next()) {
                Record med = new Record(
                        rs.getString("name"),
                        rs.getLong("phonenumber"),
                        rs.getString("email")
                );
                recordList.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }
    public void updateRecordsByName(Record r)
    {
        try {
            String query = "update Records set phonenumber = ?, email = ? where name = ?";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, r.getPhonenumber());
            stmt.setString(2, r.getEmail());
            stmt.setString(3, r.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Record getRecordsByName(String name)
    {
        String sql = "select * from Records where name = ?;";
        Record product = new Record();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, name);

            rs = stm.executeQuery();
            if(!rs.next()) return null;

            product.setName(rs.getString("name"));
            product.setPhonenumber(rs.getLong("phonenumber"));
            product.setEmail(rs.getString("email"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return product;
    }
    public void addRecordsToDB(String name, long phonenumber, String email)
    {
        try {
            String query = "insert Records values (?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setLong(2, phonenumber);
            stmt.setString(3, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean LoginUser(String login, String password) {
        String hashPassword = Integer.toString(password.hashCode());
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
    public boolean isLoginTaken(String login)
    {
        try {
            String query = "select * from Users where login = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int RegisterUser(String login, String password)
    {
        if (isLoginTaken(login))
        {
            return 1;
        }
        String hashPassword = Integer.toString(password.hashCode());
        try {
            String query = "insert Users values (?,?,2)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, hashPassword);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
