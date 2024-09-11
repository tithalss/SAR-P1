// Exemplo de classe de conexão com o banco de dados

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String url = "jdbc:postgresql://localhost:5432/seu_banco";
    private final String user = "seu_usuario";
    private final String password = "sua_senha";
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
