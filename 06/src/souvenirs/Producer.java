package souvenirs;

import java.util.List;

public class Producer implements IProducerDAO  {
    String name;
    String country;

    public Producer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


    @Override
    public List<Producer> findByPrice(int price) {
        return null;
    }

    @Override
    public List<Producer> findByYear() {
        return null;
    }

    @Override
    public void DeleteProducer() {

    }
}
