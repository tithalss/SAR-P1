package org.example.dto;

import java.time.LocalDate;

public class RefugiadoDTO {
    private String nomeCompleto;
    private String pais;
    private LocalDate dataNascimento;
    private String formacao;
    private String email;

    public RefugiadoDTO(String nomeCompleto, String pais, LocalDate dataNascimento, String formacao, String email) {
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.email = email;
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
