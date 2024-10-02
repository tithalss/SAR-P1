package org.example;

import java.time.LocalDate;

public class Voluntario {
    private int id;
    private String nomeCompleto;
    private String pais;
    private String documentacao;
    private LocalDate dataNascimento;
    private String telefone;
    private String escolaridade;
    private String formacao;
    private String email;
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
}
