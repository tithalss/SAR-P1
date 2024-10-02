package org.example;

import org.example.ClassesDAO.VoluntarioDAO;
import org.example.Services.Autenticacao;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void testaCrudVoluntario() {
        VoluntarioDAO voluntarioDAO = new VoluntarioDAO();

        Voluntario novoVoluntario = new Voluntario(
                "Dorian Yates",
                "Alemanha",
                "05805705912",
                LocalDate.of(2000, 3, 10),
                "99999999998",
                "Ensino Superior",
                "Engenharia Aeroespacial",
                "email@email.com",
                "senha"
        );
        voluntarioDAO.inserirVoluntario(novoVoluntario);
        System.out.println("Inserindo voluntário...\nVoluntário inserido com sucesso!");

        List<Voluntario> voluntarios = voluntarioDAO.buscarTodosVoluntarios();
        System.out.println("Lista de voluntários após atualização:");
        for (Voluntario voluntario : voluntarios) {
            System.out.println(voluntario);
        }

        if (!voluntarios.isEmpty()) {
            Voluntario voluntarioParaAtualizar = voluntarios.getFirst();
            voluntarioParaAtualizar.setNomeCompleto("Tom Platz");
            voluntarioParaAtualizar.setEmail("geleca@email.com");
            voluntarioDAO.atualizarVoluntario(voluntarioParaAtualizar);
            System.out.println("Atualizando informações do voluntário...\nVoluntário atualizado com sucesso!");

            // Exibir o voluntários após operação
            List<Voluntario> voluntariosAtualizados = voluntarioDAO.buscarTodosVoluntarios();
            System.out.println("Lista de voluntários após atualização:");
            for (Voluntario voluntario : voluntariosAtualizados) {
                System.out.println(voluntario);
            }
        }

        if (!voluntarios.isEmpty()) {
            Voluntario voluntarioParaExcluir = voluntarios.getFirst();
            voluntarioDAO.excluirVoluntario(voluntarioParaExcluir.getId());
            System.out.println("Excluindo voluntário...\nVoluntário excluído com sucesso!");

            // Exibir o voluntários após operação
            List<Voluntario> voluntariosAtualizados = voluntarioDAO.buscarTodosVoluntarios();
            System.out.println("Lista de voluntários após atualização:");
            for (Voluntario voluntario : voluntariosAtualizados) {
                System.out.println(voluntario);
            }
        }
    }

    public static void main(String[] args) {
        testaCrudVoluntario();

        Autenticacao autenticacao = new Autenticacao();

        String email = "email@email.com";
        String senha = "senha";

        Voluntario usuarioAutenticado = autenticacao.autenticar(email, senha);
        if (usuarioAutenticado != null) {
            System.out.println("Autenticando voluntário...\nUsuário autenticado com sucesso: " + usuarioAutenticado);
        } else {
            System.out.println("Falha na autenticação: email ou senha inválidos.");
        }
    }
}
