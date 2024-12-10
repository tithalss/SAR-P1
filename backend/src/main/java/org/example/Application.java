package org.example;

import org.example.dao.InstituicaoDAO;
import org.example.dao.RefugiadoDAO;
import org.example.dao.VoluntarioDAO;
import org.example.model.Instituicao;
import org.example.model.Refugiado;
import org.example.model.Voluntario;
import org.example.service.Autenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.util.Random;

@EnableTransactionManagement
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private VoluntarioDAO voluntarioDAO;
    @Autowired
    private Autenticacao autenticacao;
    @Autowired
    private RefugiadoDAO refugiadoDAO;
    @Autowired
    private InstituicaoDAO instituicaoDAO;

    @Override
    public void run(String... args) {
        testaCrudInstituicao();
        testaCrudVoluntario();
        testaCrudRefugiado();
    }

    public void testaCrudInstituicao() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);

        Instituicao novaInstituicao = new Instituicao(
                "Nome" + numeroAleatorio,
                "05805705987" + String.format("%03d", numeroAleatorio),
                "71996" + String.format("%3d", numeroAleatorio),
                "(61) 991526" + String.format("%3d", numeroAleatorio),
                "prot" + numeroAleatorio + "@mail.com",
                "senha"
        );
        instituicaoDAO.inserirInstituicao(novaInstituicao);
    }

    public void testaCrudVoluntario() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);

        Voluntario novoVoluntario = new Voluntario (
                "Nome" + numeroAleatorio,
                "05805705" + String.format("%03d", numeroAleatorio),
                LocalDate.of(2000, 3, 10),
                "(61) 995258" + String.format("%03d", numeroAleatorio),
                "Direito",
                "prot" + numeroAleatorio + "@mail.com"
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
                LocalDate.of(2000, 3, 10),
                "Enfermagem",
                "prot" + numeroAleatorio + "@mail.com"
        );
        refugiadoDAO.inserirRefugiado(novoRefugiado);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
