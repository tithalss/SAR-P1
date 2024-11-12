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

    @Column(name = "documentacao")
    private String documentacao;

    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Refugiado() {}

    public Refugiado(int id, String nomeCompleto, String pais, String motivoRefugio, String documentacao, LocalDate dataNascimento, String formacao, String email, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.motivoRefugio = motivoRefugio;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
    }

    public Refugiado(String nomeCompleto, String pais, String motivoRefugio, String documentacao, LocalDate dataNascimento, String formacao, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.motivoRefugio = motivoRefugio;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
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

    public String getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(String documentacao) {
        this.documentacao = documentacao;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
