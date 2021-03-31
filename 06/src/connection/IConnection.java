package connection;

import java.sql.Statement;

public interface IConnection {
    void GetConnection();
    void CloseConnection();
}
