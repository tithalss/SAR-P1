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
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private VoluntarioDAO voluntarioDAO;

    @Autowired
    private Autenticacao autenticacao;

    @Override
    public void run(String... args) {
        testaCrudVoluntario();
    }

    public void testaCrudVoluntario() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);

        // Inserção com dados dinâmicos
        Voluntario novoVoluntario = new Voluntario(
                "Nome" + numeroAleatorio,
                "Japão",
                "05805705" + String.format("%03d", numeroAleatorio),
                LocalDate.of(2000, 3, 10),
                "99999999998",
                "Ensino Superior",
                "Bacalhau",
                "prot" + numeroAleatorio + "@mail.com",
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
