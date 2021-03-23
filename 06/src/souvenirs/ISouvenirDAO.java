package souvenirs;

import java.sql.SQLException;
import java.util.List;

public interface ISouvenirDAO{
    List<Souvenir> findByProducer(String producer) throws SQLException;
    List<Souvenir> findByCountry();
}
