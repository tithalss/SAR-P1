package org.example.ClassesDAO;

import org.example.Voluntario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioDAO {
    public void inserirVoluntario(Voluntario voluntario) {
        String sql = "INSERT INTO voluntario (nomeCompleto, pais, documentacao, dataNascimento, telefone, escolaridade, formacao, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voluntario.getNomeCompleto());
            stmt.setString(2, voluntario.getPais());
            stmt.setString(3, voluntario.getDocumentacao());
            stmt.setDate(4, Date.valueOf(voluntario.getDataNascimento()));
            stmt.setString(5, voluntario.getTelefone());
            stmt.setString(6, voluntario.getEscolaridade());
            stmt.setString(7, voluntario.getFormacao());
            stmt.setString(8, voluntario.getEmail());
            stmt.setString(9, voluntario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir voluntario: " + e.getMessage());
        }
    }

    public List<Voluntario> buscarTodosVoluntarios() {
        List<Voluntario> voluntarios = new ArrayList<>();
        String sql = "SELECT * FROM voluntario";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Voluntario voluntario = new Voluntario();
                voluntario.setId(rs.getInt("id"));
                voluntario.setNomeCompleto(rs.getString("nomeCompleto"));
                voluntario.setPais(rs.getString("pais"));
                voluntario.setDocumentacao(rs.getString("documentacao"));
                voluntario.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                voluntario.setTelefone(rs.getString("telefone"));
                voluntario.setEscolaridade(rs.getString("escolaridade"));
                voluntario.setFormacao(rs.getString("formacao"));
                voluntario.setEmail(rs.getString("email"));
                voluntario.setSenha(rs.getString("senha"));
                voluntarios.add(voluntario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar voluntarios: " + e.getMessage());
        }
        return voluntarios;
    }

    public void atualizarVoluntario(Voluntario voluntario) {
        String sql = "UPDATE voluntario SET nomeCompleto = ?, pais = ?, documentacao = ?, dataNascimento = ?, telefone = ?, escolaridade = ?, formacao = ?, email = ?, senha = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voluntario.getNomeCompleto());
            stmt.setString(2, voluntario.getPais());
            stmt.setString(3, voluntario.getDocumentacao());
            stmt.setDate(4, Date.valueOf(voluntario.getDataNascimento()));
            stmt.setString(5, voluntario.getTelefone());
            stmt.setString(6, voluntario.getEscolaridade());
            stmt.setString(7, voluntario.getFormacao());
            stmt.setString(8, voluntario.getEmail());
            stmt.setString(9, voluntario.getSenha());
            stmt.setInt(10, voluntario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar voluntario: " + e.getMessage());
        }
    }

    public void excluirVoluntario(int id) {
        String sql = "DELETE FROM voluntario WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir voluntario: " + e.getMessage());
        }
    }
}
