package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private int id;

    private String nome;
    private String descricao;
    private int numeroRegistro;

    @Column(unique = true, nullable = false) // CNPJ deve ser único e não nulo
    private String cnpj;

    private String cep;
    private String nomeRepresentante;

    @Column(unique = true, nullable = false) // CPF do representante também único e obrigatório
    private String cpfRepresentante;

    @Column(unique = true, nullable = false) // Email único e obrigatório
    private String email;

    private String senha;

    // Construtor sem id
    public Instituicao() {}

    public Instituicao(String nome, String descricao, int numeroRegistro, String cnpj, String cep,
                       String nomeRepresentante, String cpfRepresentante, String email, String senha) {
        this.nome = nome;
        this.descricao = descricao;
        this.numeroRegistro = numeroRegistro;
        this.cnpj = cnpj;
        this.cep = cep;
        this.nomeRepresentante = nomeRepresentante;
        this.cpfRepresentante = cpfRepresentante;
        this.email = email;
        this.senha = senha;
    }

    // Construtor com id
    public Instituicao(int id, String nome, String descricao, int numeroRegistro, String cnpj, String cep,
                       String nomeRepresentante, String cpfRepresentante, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.numeroRegistro = numeroRegistro;
        this.cnpj = cnpj;
        this.cep = cep;
        this.nomeRepresentante = nomeRepresentante;
        this.cpfRepresentante = cpfRepresentante;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
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

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCpfRepresentante() {
        return cpfRepresentante;
    }

    public void setCpfRepresentante(String cpfRepresentante) {
        this.cpfRepresentante = cpfRepresentante;
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
