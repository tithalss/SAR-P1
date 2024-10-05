package org.example;

import org.example.ClassesDAO.VoluntarioDAO;
import org.example.Services.Autenticacao;
import org.example.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private VoluntarioDAO voluntarioDAO;

    @Autowired
    private Autenticacao autenticacao;

    @Override
    public void run(String... args) {
        // Chame seus métodos de teste aqui
        testaCrudVoluntario();
        autenticarUsuario();
    }

    public void autenticarUsuario() {
        String email = "email@email.com";
        String senha = "senha";

        Voluntario usuarioAutenticado = autenticacao.autenticar(email, senha);
        if (usuarioAutenticado != null) {
            System.out.println("Autenticando voluntário...\nUsuário autenticado com sucesso: " + usuarioAutenticado);
        } else {
            System.out.println("Falha na autenticação: email ou senha inválidos.");
        }
    }

    public void testaCrudVoluntario() {
        Voluntario novoVoluntario = new Voluntario(
                "Ives São Paulino Yates",
                "Alemanha",
                "05805705912",
                LocalDate.of(2000, 3, 10),
                "99999999998",
                "Ensino Superior",
                "Engenharia Aeroespacial",
                "travestipirocudo@email.com",
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
            Voluntario voluntarioParaAtualizar = voluntarios.get(0);
            voluntarioParaAtualizar.setNomeCompleto("Tom Platz");
            voluntarioParaAtualizar.setEmail("geleca@email.com");
            voluntarioDAO.atualizarVoluntario(voluntarioParaAtualizar);
            System.out.println("Atualizando informações do voluntário...\nVoluntário atualizado com sucesso!");

            // Exibir os voluntários após a atualização
            List<Voluntario> voluntariosAtualizados = voluntarioDAO.buscarTodosVoluntarios();
            System.out.println("Lista de voluntários após atualização:");
            for (Voluntario voluntario : voluntariosAtualizados) {
                System.out.println(voluntario);
            }
        }

        if (!voluntarios.isEmpty()) {
            Voluntario voluntarioParaExcluir = voluntarios.get(0);
            voluntarioDAO.excluirVoluntario(voluntarioParaExcluir.getId());
            System.out.println("Excluindo voluntário...\nVoluntário excluído com sucesso!");

            // Exibir os voluntários após a exclusão
            List<Voluntario> voluntariosAtualizados = voluntarioDAO.buscarTodosVoluntarios();
            System.out.println("Lista de voluntários após atualização:");
            for (Voluntario voluntario : voluntariosAtualizados) {
                System.out.println(voluntario);
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
