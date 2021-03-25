package main;

import connection.SQLServerConnection;

import java.sql.Statement;
import java.util.logging.Logger;
import static souvenirs.IJava_Souvenir.*;

public class Main {

    private static final Logger JAVA_SOUVENIRS_LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        SQLServerConnection Java_Souvenirs = new SQLServerConnection("Java_Souvenirs");
        try {
            JAVA_SOUVENIRS_LOGGER.info("Creating new connection");
            Java_Souvenirs.GetConnection();
            JAVA_SOUVENIRS_LOGGER.info("findSouvenirsByProducer()");
            findSouvenirsByProducer(Java_Souvenirs.connection, "KORADO");
            JAVA_SOUVENIRS_LOGGER.info("findSouvenirsByCountry()");
            findSouvenirsByCountry(Java_Souvenirs.connection, "Belarus");
            JAVA_SOUVENIRS_LOGGER.info("findProducersByPrice()");
            findProducersByPrice(Java_Souvenirs.connection, 15);
            JAVA_SOUVENIRS_LOGGER.info("findSouvenirByNameAndYear()");
            findSouvenirByNameAndYear(Java_Souvenirs.connection, 2020, "Magnet Minsk");
            JAVA_SOUVENIRS_LOGGER.info("deleteProducer()");
            deleteProducer(Java_Souvenirs.connection, "1434");

            //tran
            try{
                Java_Souvenirs.connection.setAutoCommit(false);
                Statement statement1 = null;
                try{
                    statement1 = Java_Souvenirs.connection.createStatement();
                    statement1.executeUpdate("UPDATE PRODUCERS set name='KORADOcz' where NAME='KORADO'");
                } finally {
                    if(statement1 != null) {
                        statement1.close();
                    }
                }
                Statement statement2 = null;
                try{
                    statement2 = Java_Souvenirs.connection.createStatement();
                    statement2.executeUpdate("UPDATE SOUVENIRS set price=100 where ProducerID=1124");
                }
                finally {
                    if(statement2 != null) {
                        statement2.close();
                    }
                }
                Java_Souvenirs.connection.commit();
            } catch(Exception e) {
                Java_Souvenirs.connection.rollback();
            }

            findSouvenirsByProducer(Java_Souvenirs.connection, "KORADOcz");

        } catch (Exception e) {
            JAVA_SOUVENIRS_LOGGER.info("EXCEPTION");
            System.out.print("Exception in main: ");
            System.out.println(e.getMessage());
        } finally {
            JAVA_SOUVENIRS_LOGGER.info("Closing the connection");
           Java_Souvenirs.CloseConnection();
        }
    }

}
