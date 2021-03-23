package main;

import connection.SQLServerConnection;

import static souvenirs.IJava_Souvenir.*;

//TODO add logger

public class Main {

    public static void main(String[] args) {
        SQLServerConnection Java_Souvenirs = new SQLServerConnection("Java_Souvenirs");
        try {
            Java_Souvenirs.GetConnection();
            findSouvenirsByProducer(Java_Souvenirs.connection, "KORADO");
            findSouvenirsByCountry(Java_Souvenirs.connection, "Belarus");
            findProducersByPrice(Java_Souvenirs.connection, 15);
            findSouvenirByNameAndYear(Java_Souvenirs.connection, 2020, "Magnet Minsk");
            deleteProducer(Java_Souvenirs.connection, "1434");

        } catch (Exception e) {
            System.out.print("Exception in main: ");
            System.out.println(e.getMessage());
        } finally {
           Java_Souvenirs.CloseConnection();
        }
    }

}
