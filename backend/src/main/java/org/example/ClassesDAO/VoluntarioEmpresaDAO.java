package org.example.ClassesDAO;

import org.example.VoluntarioEmpresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioEmpresaDAO {
    public void inserirVoluntarioEmpresa(VoluntarioEmpresa voluntarioEmpresa) {
        String sql = "INSERT INTO voluntario_empresa (nomeCompleto, pais, documentacao, dataNascimento, telefone, escolaridade, formacao, email, senha, id_instituicao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voluntarioEmpresa.getNomeCompleto());
            stmt.setString(2, voluntarioEmpresa.getPais());
            stmt.setString(3, voluntarioEmpresa.getDocumentacao());
            stmt.setDate(4, Date.valueOf(voluntarioEmpresa.getDataNascimento()));
            stmt.setString(5, voluntarioEmpresa.getTelefone());
            stmt.setString(6, voluntarioEmpresa.getEscolaridade());
            stmt.setString(7, voluntarioEmpresa.getFormacao());
            stmt.setString(8, voluntarioEmpresa.getEmail());
            stmt.setString(9, voluntarioEmpresa.getSenha());
            stmt.setInt(10, voluntarioEmpresa.getIdInstituicao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir voluntario_empresa: " + e.getMessage());
        }
    }

    public List<VoluntarioEmpresa> buscarTodosVoluntariosEmpresa() {
        List<VoluntarioEmpresa> voluntariosEmpresa = new ArrayList<>();
        String sql = "SELECT * FROM voluntario_empresa";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                VoluntarioEmpresa voluntarioEmpresa = new VoluntarioEmpresa();
                voluntarioEmpresa.setId(rs.getInt("id"));
                voluntarioEmpresa.setNomeCompleto(rs.getString("nomeCompleto"));
                voluntarioEmpresa.setPais(rs.getString("pais"));
                voluntarioEmpresa.setDocumentacao(rs.getString("documentacao"));
                voluntarioEmpresa.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                voluntarioEmpresa.setTelefone(rs.getString("telefone"));
                voluntarioEmpresa.setEscolaridade(rs.getString("escolaridade"));
                voluntarioEmpresa.setFormacao(rs.getString("formacao"));
                voluntarioEmpresa.setEmail(rs.getString("email"));
                voluntarioEmpresa.setSenha(rs.getString("senha"));
                voluntarioEmpresa.setIdInstituicao(rs.getInt("id_instituicao"));
                voluntariosEmpresa.add(voluntarioEmpresa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar voluntarios_empresa: " + e.getMessage());
        }
        return voluntariosEmpresa;
    }

    public void atualizarVoluntarioEmpresa(VoluntarioEmpresa voluntarioEmpresa) {
        String sql = "UPDATE voluntario_empresa SET nomeCompleto = ?, pais = ?, documentacao = ?, dataNascimento = ?, telefone = ?, escolaridade = ?, formacao = ?, email = ?, senha = ?, id_instituicao = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voluntarioEmpresa.getNomeCompleto());
            stmt.setString(2, voluntarioEmpresa.getPais());
            stmt.setString(3, voluntarioEmpresa.getDocumentacao());
            stmt.setDate(4, Date.valueOf(voluntarioEmpresa.getDataNascimento()));
            stmt.setString(5, voluntarioEmpresa.getTelefone());
            stmt.setString(6, voluntarioEmpresa.getEscolaridade());
            stmt.setString(7, voluntarioEmpresa.getFormacao());
            stmt.setString(8, voluntarioEmpresa.getEmail());
            stmt.setString(9, voluntarioEmpresa.getSenha());
            stmt.setInt(10, voluntarioEmpresa.getIdInstituicao());
            stmt.setInt(11, voluntarioEmpresa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar voluntario_empresa: " + e.getMessage());
        }
    }

    public void excluirVoluntarioEmpresa(int id) {
        String sql = "DELETE FROM voluntario_empresa WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir voluntario_empresa: " + e.getMessage());
        }
    }
}
