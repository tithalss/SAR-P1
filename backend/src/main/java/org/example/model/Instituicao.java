package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "telefone", unique = true, nullable = false)
    private String telefone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Instituicao() {}

    public Instituicao(String nome, String cnpj, String cep, String telefone, String email, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Instituicao(int id, String nome, String cnpj, String cep, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
