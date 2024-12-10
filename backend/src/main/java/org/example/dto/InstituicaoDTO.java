package org.example.dto;

public class InstituicaoDTO {
    private String nome;
    private String cnpj;
    private String cep;
    private String email;
    private String senha;
    private String novaSenha;

    public InstituicaoDTO(){}

    public InstituicaoDTO(String nome, String cnpj, String cep, String email, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.email = email;
        this.senha = senha;
    }

    public InstituicaoDTO(String nome, String cnpj, String cep, String email, String senha, String novaSenha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.email = email;
        this.senha = senha;
        this.novaSenha = novaSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
