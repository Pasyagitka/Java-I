package souvenirs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IJava_Souvenir {

    static void findSouvenirsByProducer(Connection n, String producerName) throws SQLException {
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
            String souvenir = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");
            String country = resultSet.getString("Country");

            System.out.printf("%s - %s - %s - %s\n", producer, souvenir, price, country);
        }
    }

    static void findSouvenirsByCountry(Connection n, String countryName) throws SQLException {
        String QSouvenirsByCountry =
                "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                        "FROM Souvenirs inner join Producers\n" +
                        "    P on P.ProducerID = Souvenirs.ProducerID\n" +
                        "WHERE P.Country=?;\n";
        PreparedStatement SouvenirsByCountry = n.prepareStatement(QSouvenirsByCountry);
        SouvenirsByCountry.setString(1, countryName);
        var resultSet = SouvenirsByCountry.executeQuery();

        System.out.println("---------------Souvenirs by country");
        while(resultSet.next()){

            String producer = resultSet.getString("Producer");
            String souvenir = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");
            String country = resultSet.getString("Country");

            System.out.printf("%s - %s - %s - %s\n", producer, souvenir, price, country);
        }
    }

    static void findProducersByPrice(Connection db, int marginprice)  throws SQLException{
        String QProducersByPrice = "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                "FROM Souvenirs inner join Producers\n" +
                "    P on P.ProducerID = Souvenirs.ProducerID\n" +
                "WHERE Souvenirs.price<?";
        PreparedStatement ProducersByPrice = db.prepareStatement(QProducersByPrice);
        ProducersByPrice.setInt(1, marginprice);
        var resultSet = ProducersByPrice.executeQuery();

        System.out.println("---------------Producers with souvenirs.price < " + marginprice);
        while(resultSet.next()){

            String producer = resultSet.getString("Producer");
            String souvenir = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");

            System.out.printf("%s - %s - %s\n", producer, souvenir, price);
        }
    }

    static void findSouvenirByNameAndYear(Connection db, int productionYear, String souvenirName)  throws SQLException{
        String QSouvenirByNameAndYear = "SELECT P.Name Producer, Date Date, Souvenirs.Name Souvenir, price Price , country Country\n" +
                "FROM Souvenirs inner join Producers\n" +
                "    P on P.ProducerID = Souvenirs.ProducerID\n" +
                "WHERE year(Souvenirs.Date)=? AND Souvenirs.Name=?";
        PreparedStatement SouvenirsByNameAndYear = db.prepareStatement(QSouvenirByNameAndYear);
        SouvenirsByNameAndYear.setInt(1, productionYear);
        SouvenirsByNameAndYear.setString(2, souvenirName);
        var resultSet = SouvenirsByNameAndYear.executeQuery();

        System.out.printf("---------------Souvenir \"%s\" produced in %d\n", souvenirName, productionYear);
        while(resultSet.next()){

            String producer = resultSet.getString("Producer");
            String souvenir = resultSet.getString("Souvenir");
            int price = resultSet.getInt("Price");
            String country = resultSet.getString("Country");

            System.out.printf("%s - %s - %s - %s\n", producer, souvenir, price, country);
        }
    }

    static void deleteProducer(Connection db, String producerID) throws  SQLException {
        String QDeleteSouvenirs = "DELETE FROM Souvenirs WHERE ProducerID = ? ";
        PreparedStatement deleteS = db.prepareStatement(QDeleteSouvenirs);
        deleteS.setString(1, producerID);
        int rowsaffectedS = deleteS.executeUpdate();

        String QDeleteProducer = "DELETE FROM Producers WHERE Producers.ProducerID =?;\n";
        PreparedStatement deleteP = db.prepareStatement(QDeleteProducer);
        deleteP.setString(1, producerID);
        int rowsaffectedP = deleteP.executeUpdate();

        System.out.printf("---------------Delete Producer %s, %d rows P, %d rows S\n", producerID, rowsaffectedP, rowsaffectedS);
    }

}
