package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "voluntario")
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeCompleto", nullable = false)
    private String nomeCompleto;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "documentacao", unique = true, nullable = false)
    private String documentacao;

    @Column(name = "dataNascimento", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "escolaridade", nullable = false)
    private String escolaridade;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Voluntario() {}

    // Construtor sem o ID
    public Voluntario(String nomeCompleto, String pais, String documentacao, LocalDate dataNascimento, String telefone,
                      String escolaridade, String formacao, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.escolaridade = escolaridade;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
    }

    // Construtor com o ID
    public Voluntario(int id, String nomeCompleto, String pais, String documentacao, LocalDate dataNascimento, String telefone,
                      String escolaridade, String formacao, String email, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.escolaridade = escolaridade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
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

    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", pais='" + pais + '\'' +
                ", documentacao='" + documentacao + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", escolaridade='" + escolaridade + '\'' +
                ", formacao='" + formacao + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
