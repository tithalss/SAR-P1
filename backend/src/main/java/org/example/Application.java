package org.example;

import org.example.dao.VoluntarioDAO;
import org.example.service.Autenticacao;
import org.example.model.Voluntario;
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
        //autenticarUsuario();
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
                "Malandro",
                "Portugal",
                "05805705912",
                LocalDate.of(2000, 3, 10),
                "99999999998",
                "Ensino Superior",
                "Bacalhau",
                "mail@email.com",
                "senha"
        );
        voluntarioDAO.inserirVoluntario(novoVoluntario);
        System.out.println("Inserindo voluntário...\nVoluntário inserido com sucesso!");

        List<Voluntario> voluntarios = voluntarioDAO.buscarTodosVoluntarios();
        System.out.println("Lista de voluntários após atualização:");
        for (Voluntario voluntario : voluntarios) {
            System.out.println(voluntario);
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
