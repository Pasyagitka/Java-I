package souvenirs;

import connection.SQLServerConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Souvenir implements ISouvenirDAO{
    String name;
    String producerID;
    Date productionDate;
    int price;

    public Souvenir() {}

    public Souvenir(String name, String producerID, Date productionDate, int price) {
        this.name = name;
        this.producerID = producerID;
        this.productionDate = productionDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducerID() {
        return producerID;
    }

    public void setProducerID(String producerID) {
        this.producerID = producerID;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", producerID='" + producerID + '\'' +
                ", productionDate=" + productionDate +
                ", price=" + price +
                '}';
    }

    @Override
    public List<Souvenir> findByProducer(String producer) throws SQLException {

        return null;
    }

    @Override
    public List<Souvenir> findByCountry() {
        return null;
    }
}
