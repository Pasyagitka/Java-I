package connection;

import java.sql.Statement;

public interface IConnection {
    default void GetConnection() {};
    default void CloseConnection()  {};
}
