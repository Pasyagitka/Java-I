package connection;

import java.sql.Statement;

public interface IConnection {
    //static Statement GetConnection(String database) {};
    static void CloseConnection(Statement openedConnection)  {};
}
