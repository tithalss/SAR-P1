package org.example;

import java.time.LocalDate;

public class Refugiado {
    private int id;
    private String nomeCompleto;
    private String pais;
    private String motivoRefugio;
    private String documentacao;
    private LocalDate dataNascimento;
    private String formacao;
    private String email;
    private String senha;
    private byte[] fotoPerfil;

    public Refugiado() {}

    // Construtor sem o ID
    public Refugiado(String nomeCompleto, String pais, String motivoRefugio, String documentacao, LocalDate dataNascimento, String formacao, String email, String senha, byte[] fotoPerfil) {
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.motivoRefugio = motivoRefugio;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
    }

    // Construtor com o ID
    public Refugiado(int id, String nomeCompleto, String pais, String motivoRefugio, String documentacao, LocalDate dataNascimento, String formacao, String email, String senha, byte[] fotoPerfil) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.motivoRefugio = motivoRefugio;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
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

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
