package main;

import connection.SQLServerConnection;
import souvenirs.Souvenir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.SQLServerConnection.CloseConnection;
import static connection.SQLServerConnection.GetConnection;
//TODO add logger

public class Main {

    public static void main(String[] args) {
        try {
            Connection java_souvenirs = GetConnection("Java_Souvenirs");
            findSouvenirsByProducer(java_souvenirs, "KORADO");
            findSouvenirsByCountry(java_souvenirs, "Belarus");
            findProducersByPrice(java_souvenirs, 15);
            findSouvenirByNameAndYear(java_souvenirs, 2020, "Magnet Minsk");
            deleteProducer(java_souvenirs, "1434");

        } catch (Exception e) {
            System.out.print("Exception in main: ");
            System.out.println(e.getMessage());
        } finally {
            CloseConnection("Java_Souvenirs");
        }
    }

    public static void findSouvenirsByProducer(Connection n, String producerName) throws SQLException {
        String QSouvenirsByProducer =
                "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                        "FROM Souvenirs inner join Producers\n P on P.ProducerID = Souvenirs.ProducerID\n" +
                        "WHERE P.Name=?";
        PreparedStatement SouvenirsByProducer = n.prepareStatement(QSouvenirsByProducer);
        SouvenirsByProducer.setString(1, producerName);
        var resultSet = SouvenirsByProducer.executeQuery();

        System.out.println("---------------Souvenirs by producer");
        while(resultSet.next()){
            String producer = resultSet.getString("Producer");
            String souvenier = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");
            String country = resultSet.getString("Country");

            System.out.printf("%s - %s - %s - %s\n", producer, souvenier, price, country);
        }
    }

    public static void findSouvenirsByCountry(Connection n, String countryName) throws SQLException {
        String QSouvenirsByCountry =
                "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                        "FROM Souvenirs inner join Producers\n" +
                        "    P on P.ProducerID = Souvenirs.ProducerID\n" +
                        "WHERE P.Country=?;\n";
        PreparedStatement SouvenirsByProducer = n.prepareStatement(QSouvenirsByCountry);
        SouvenirsByProducer.setString(1, countryName);
        var resultSet = SouvenirsByProducer.executeQuery();

        System.out.println("---------------Souvenirs by country");
        while(resultSet.next()){

            String producer = resultSet.getString("Producer");
            String souvenier = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");
            String country = resultSet.getString("Country");

            System.out.printf("%s - %s - %s - %s\n", producer, souvenier, price, country);
        }
    }

    public static void findProducersByPrice(Connection db, int marginprice)  throws SQLException{
        String QProducersByPrice = "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                "FROM Souvenirs inner join Producers\n" +
                "    P on P.ProducerID = Souvenirs.ProducerID\n" +
                "WHERE Souvenirs.price<?";
        PreparedStatement SouvenirsByProducer = db.prepareStatement(QProducersByPrice);
        SouvenirsByProducer.setInt(1, marginprice);
        var resultSet = SouvenirsByProducer.executeQuery();

        System.out.println("---------------Producers with souvenirs.price < " + marginprice);
        while(resultSet.next()){

            String producer = resultSet.getString("Producer");
            String souvenier = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");

            System.out.printf("%s - %s - %s\n", producer, souvenier, price);
        }
    }
    //TODO rename souvenirs in methods

    public static void findSouvenirByNameAndYear(Connection db, int productionYear, String souvenirName)  throws SQLException{
        String QSouvenirByNameAndYear = "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                "FROM Souvenirs inner join Producers\n" +
                "    P on P.ProducerID = Souvenirs.ProducerID\n" +
                "WHERE year(Souvenirs.Date)=? AND Souvenirs.Name=?";
        PreparedStatement SouvenirsByProducer = db.prepareStatement(QSouvenirByNameAndYear);
        SouvenirsByProducer.setInt(1, productionYear);
        SouvenirsByProducer.setString(2, souvenirName);
        var resultSet = SouvenirsByProducer.executeQuery();

        System.out.printf("---------------Souvenir \"%s\" produced in %d\n", souvenirName, productionYear);
        while(resultSet.next()){

            String producer = resultSet.getString("Producer");
            String souvenier = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");
            String country = resultSet.getString("Country");

            System.out.printf("%s - %s - %s - %s\n", producer, souvenier, price, country);
        }
    }
    //TODO rename variables (query)

    public static void deleteProducer(Connection db, String producerID) throws  SQLException {
        String QdeleteSouvenirs = "DELETE FROM Souvenirs WHERE ProducerID = ? ";
        PreparedStatement deleteS = db.prepareStatement(QdeleteSouvenirs);
        deleteS.setString(1, producerID);
        int rowsaffectedS = deleteS.executeUpdate();

        String QdeleteProducer = "DELETE FROM Producers WHERE Producers.ProducerID =?;\n";
        PreparedStatement deleteP = db.prepareStatement(QdeleteProducer);
        deleteP.setString(1, producerID);
        int rowsaffectedP = deleteP.executeUpdate();

        System.out.printf("---------------Delete Producer %s, %d rows P, %d rows S\n", producerID, rowsaffectedP, rowsaffectedS);
    }
}
