package org.example.ClassesDAO;

import org.example.Instituicao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoDAO {
    public void inserirInstituicao(Instituicao instituicao) {
        String sql = "INSERT INTO instituicao (nome, descricao, numeroRegistro, cnpj, cep, nomeRepresentante, cpfRepresentante, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instituicao.getNome());
            stmt.setString(2, instituicao.getDescricao());
            stmt.setInt(3, instituicao.getNumeroRegistro());
            stmt.setString(4, instituicao.getCnpj());
            stmt.setString(5, instituicao.getCep());
            stmt.setString(6, instituicao.getNomeRepresentante());
            stmt.setString(7, instituicao.getCpfRepresentante());
            stmt.setString(8, instituicao.getEmail());
            stmt.setString(9, instituicao.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir insituição: " + e.getMessage());
        }
    }

    public List<Instituicao> buscarTodasInstituicoes() {
        List<Instituicao> instituicoes = new ArrayList<>();
        String sql = "SELECT * FROM instituicao";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Instituicao instituicao = new Instituicao();
                instituicao.setId(rs.getInt("id"));
                instituicao.setNome(rs.getString("nome"));
                instituicao.setDescricao(rs.getString("descricao"));
                instituicao.setNumeroRegistro(rs.getInt("numeroRegistro"));
                instituicao.setCnpj(rs.getString("cnpj"));
                instituicao.setCep(rs.getString("cep"));
                instituicao.setNomeRepresentante(rs.getString("nomeRepresentante"));
                instituicao.setCpfRepresentante(rs.getString("cpfRepresentante"));
                instituicao.setEmail(rs.getString("email"));
                instituicao.setSenha(rs.getString("senha"));
                instituicoes.add(instituicao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar instituicaos: " + e.getMessage());
        }
        return instituicoes;
    }

    public void atualizarInstituicao(Instituicao instituicao) {
        String sql = "UPDATE instituicao SET nome = ?, descricao = ?, numeroRegistro = ?, cnpj = ?, cep = ?, nomeRepresentante = ?, cpfRepresentante = ?, email = ?, senha = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instituicao.getNome());
            stmt.setString(2, instituicao.getDescricao());
            stmt.setInt(3, instituicao.getNumeroRegistro());
            stmt.setString(4, instituicao.getCnpj());
            stmt.setString(5, instituicao.getCep());
            stmt.setString(6, instituicao.getNomeRepresentante());
            stmt.setString(7, instituicao.getCpfRepresentante());
            stmt.setString(8, instituicao.getEmail());
            stmt.setString(9, instituicao.getSenha());
            stmt.setInt(10, instituicao.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar instituicao: " + e.getMessage());
        }
    }

    public void excluirInstituicao(int id) {
        String sql = "DELETE FROM instituicao WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir instituicao: " + e.getMessage());
        }
    }
}