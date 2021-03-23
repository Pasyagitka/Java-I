package souvenirs;

import java.util.List;

public interface IProducerDAO  {
    List<Producer> findByPrice(int price);
    List<Producer> findByYear();
    void DeleteProducer();
}
