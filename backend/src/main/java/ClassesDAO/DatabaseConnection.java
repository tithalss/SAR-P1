package ClassesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // String de conexão para o Supabase
        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?user=postgres.eqxskcklrytovvufbtly&password=wOqdEb9ruJTPwlFx";

        // Abrir conexão
        try {
            // Registre o driver (opcional para versões mais novas)
            Class.forName("org.postgresql.Driver");

            // Tente estabelecer a conexão
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    System.out.println("Conexão estabelecida com sucesso!");
                } else {
                    System.out.println("Falha ao conectar!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        }
    }
}