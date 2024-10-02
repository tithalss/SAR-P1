package org.example.ClassesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.eqxskcklrytovvufbtly";
    private static final String PASSWORD = "wOqdEb9ruJTPwlFx";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // Certifica o registro do driver do postgre (desnecessário a depender da versão)
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("=#");

        } catch (SQLException e) {
            System.err.println("Erro de SQL ao conectar: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver do PostgreSQL não encontrado: " + e.getMessage());
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}