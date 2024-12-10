package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "refugiado")
public class Refugiado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeCompleto", nullable = false)
    private String nomeCompleto;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "motivoRefugio", nullable = false)
    private String motivoRefugio;

    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "email", unique = true)
    private String email;

    public Refugiado() {}

    public Refugiado(String nomeCompleto, String pais, String motivoRefugio, LocalDate dataNascimento, String formacao, String email) {
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.motivoRefugio = motivoRefugio;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
    }

    public Refugiado(int id, String nomeCompleto, String pais, String motivoRefugio, LocalDate dataNascimento, String formacao, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.motivoRefugio = motivoRefugio;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMotivoRefugio() {
        return motivoRefugio;
    }

    public void setMotivoRefugio(String motivoRefugio) {
        this.motivoRefugio = motivoRefugio;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
