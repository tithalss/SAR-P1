package org.example.ClassesDAO;

import org.example.Refugiado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefugiadoDAO {

    public void inserirRefugiado(Refugiado refugiado) {
        String sql = "INSERT INTO refugiado (nomeCompleto, pais, motivoRefugio, documentacao, dataNascimento, formacao, email, senha, fotoPerfil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, refugiado.getNomeCompleto());
            stmt.setString(2, refugiado.getPais());
            stmt.setString(3, refugiado.getMotivoRefugio());
            stmt.setString(4, refugiado.getDocumentacao());
            stmt.setDate(5, Date.valueOf(refugiado.getDataNascimento()));
            stmt.setString(6, refugiado.getFormacao());
            stmt.setString(7, refugiado.getEmail());
            stmt.setString(8, refugiado.getSenha());
            stmt.setBytes(9, refugiado.getFotoPerfil());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir refugiado: " + e.getMessage());
        }
    }

    public List<Refugiado> buscarTodosRefugiados() {
        List<Refugiado> refugiados = new ArrayList<>();
        String sql = "SELECT * FROM refugiado";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Refugiado refugiado = new Refugiado();
                refugiado.setId(rs.getInt("id"));
                refugiado.setNomeCompleto(rs.getString("nomeCompleto"));
                refugiado.setPais(rs.getString("pais"));
                refugiado.setMotivoRefugio(rs.getString("motivoRefugio"));
                refugiado.setDocumentacao(rs.getString("documentacao"));
                refugiado.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                refugiado.setFormacao(rs.getString("formacao"));
                refugiado.setEmail(rs.getString("email"));
                refugiado.setSenha(rs.getString("senha"));
                refugiado.setFotoPerfil(rs.getBytes("fotoPerfil"));
                refugiados.add(refugiado);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar refugiados: " + e.getMessage());
        }
        return refugiados;
    }

    public void atualizarRefugiado(Refugiado refugiado) {
        String sql = "UPDATE refugiado SET nomeCompleto = ?, pais = ?, motivoRefugio = ?, documentacao = ?, dataNascimento = ?, formacao = ?, email = ?, senha = ?, fotoPerfil = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, refugiado.getNomeCompleto());
            stmt.setString(2, refugiado.getPais());
            stmt.setString(3, refugiado.getMotivoRefugio());
            stmt.setString(4, refugiado.getDocumentacao());
            stmt.setDate(5, Date.valueOf(refugiado.getDataNascimento()));
            stmt.setString(6, refugiado.getFormacao());
            stmt.setString(7, refugiado.getEmail());
            stmt.setString(8, refugiado.getSenha());
            stmt.setBytes(9, refugiado.getFotoPerfil());
            stmt.setInt(10, refugiado.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar refugiado: " + e.getMessage());
        }
    }

    public void excluirRefugiado(int id) {
        String sql = "DELETE FROM refugiado WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir refugiado: " + e.getMessage());
        }
    }
}
