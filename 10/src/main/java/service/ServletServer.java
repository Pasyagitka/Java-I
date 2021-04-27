package service;

import by.malinka.dao.DAOFactory;
import by.malinka.medcenter.Med;
import by.malinka.medcenter.MedCenter;

import java.sql.*;

public class ServletServer {
    private static ServletServer instance;
    ResultSet rs;
    PreparedStatement stmt;
    private final Connection connection;

    public static ServletServer getInstance()
    {
        if ( instance != null) return instance;
        instance = new ServletServer();
        return instance;
    }

    private ServletServer()
    {
        DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Lab9",
                "User2", "1234");
        connection = daoFactory.getConnection();
    }
    public MedCenter getMedsFromDB()
    {
        String sql = "select * from Meds;";
        MedCenter medCenter = MedCenter.getInstance();
        medCenter.clear();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            rs = stm.executeQuery();
            while (rs.next()) {
                Med med = new Med(
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("releaseDate")
                );
                medCenter.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medCenter;
    }
    public void updateProductByName(Med med)
    {
        try {
            String query = "update Meds set price = ?, releaseDate = ? where name = ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, med.getPrice());
            stmt.setDate(2, med.getReleaseData());
            stmt.setString(3, med.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Med getMedByName(String name)
    {
        String sql = "select * from Meds where name = ?;";
        Med product = new Med();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, name);

            rs = stm.executeQuery();
            if(!rs.next()) return null;

            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setReleaseData(rs.getDate("releaseDate"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return product;
    }
    public void addMedToDB(String name, int price, Date releaseDate)
    {
        try {
            String query = "insert Meds values (?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setDate(3, releaseDate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public boolean LoginUser(String login, String password) {
        String hashPassword = Integer.toString(password.hashCode());
        String query = "select* from Users as U where U.login = ? and U.password = ?";
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
            String query = "select* from Users where Users.login = ?";
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
