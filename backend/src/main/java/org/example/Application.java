package org.example;

import org.example.dao.RefugiadoDAO;
import org.example.dao.VoluntarioDAO;
import org.example.model.Refugiado;
import org.example.model.Voluntario;
import org.example.service.Autenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private VoluntarioDAO voluntarioDAO;

    @Autowired
    private Autenticacao autenticacao;
    @Autowired
    private RefugiadoDAO refugiadoDAO;

    @Override
    public void run(String... args) {
        testaCrudVoluntario();
        testaCrudRefugiado();
    }

    public void testaCrudVoluntario() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);

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
    }

    public void testaCrudRefugiado() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);

        Refugiado novoRefugiado = new Refugiado (
                "Nome" + numeroAleatorio,
                "Brasil",
                "Motivo desconhecido",
                "9090.456-" + String.format("%03d", numeroAleatorio),
                LocalDate.of(2000, 3, 10),
                "Enfermagem",
                "prot" + numeroAleatorio + "@mail.com",
                "senha" + numeroAleatorio
        );
        refugiadoDAO.inserirRefugiado(novoRefugiado);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
