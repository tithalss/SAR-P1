package org.example;

import org.example.ClassesDAO.DatabaseConnection;
import org.example.ClassesDAO.VoluntarioDAO;
import org.example.Services.Autenticacao;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void testaCrudVoluntario() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        VoluntarioDAO voluntarioDAO = new VoluntarioDAO();

        // 1. Criar e inserir um voluntário
        Voluntario novoVoluntario = new Voluntario(
                "Thales Martins",
                "Austrália",
                "05805705912",
                LocalDate.of(2000, 3, 10),
                "99999999998",
                "Ensino Superior",
                "Engenharia Aeroespacial",
                "email@email.com",
                "123456"
        );
        voluntarioDAO.inserirVoluntario(novoVoluntario);
        System.out.println("Voluntário inserido com sucesso!");

        // 2. Buscar todos os voluntários
        List<Voluntario> voluntarios = voluntarioDAO.buscarTodosVoluntarios();
        System.out.println("Lista de voluntários:");
        for (Voluntario voluntario : voluntarios) {
            System.out.println(voluntario);
        }

        /* 3. Atualizar um voluntário existente (vamos usar o primeiro da lista)
        if (!voluntarios.isEmpty()) {
            Voluntario voluntarioParaAtualizar = voluntarios.get(0);
            voluntarioParaAtualizar.setNomeCompleto("João Silva Atualizado");
            voluntarioParaAtualizar.setEmail("joao.atualizado@example.com");
            voluntarioDAO.atualizarVoluntario(voluntarioParaAtualizar);
            System.out.println("Voluntário atualizado com sucesso!");

            // Exibir o voluntário atualizado
            List<Voluntario> voluntariosAtualizados = voluntarioDAO.buscarTodosVoluntarios();
            System.out.println("Lista de voluntários após atualização:");
            for (Voluntario voluntario : voluntariosAtualizados) {
                System.out.println(voluntario);
            }
        }

         4. Excluir um voluntário (vamos excluir o primeiro da lista atualizada)
        if (!voluntarios.isEmpty()) {
            Voluntario voluntarioParaExcluir = voluntarios.get(0);
            voluntarioDAO.excluirVoluntario(voluntarioParaExcluir.getId());
            System.out.println("Voluntário excluído com sucesso!");
        }*/
    }

    public static void main(String[] args) {
        testaCrudVoluntario();

        Autenticacao autenticacao = new Autenticacao();

        // Exemplo de autenticação
        String email = "email@email.com";
        String senha = "123456";

        Voluntario usuarioAutenticado = autenticacao.autenticar(email, senha);
        if (usuarioAutenticado != null) {
            System.out.println("Usuário autenticado com sucesso: " + usuarioAutenticado);
        } else {
            System.out.println("Falha na autenticação: email ou senha inválidos.");
        }
    }
}
