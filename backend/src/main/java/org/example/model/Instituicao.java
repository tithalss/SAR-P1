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

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "numeroRegistro")
    private int numeroRegistro;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "cep", unique = true, nullable = false)
    private String cep;

    @Column(name = "nomeRepresentante", nullable = false)
    private String nomeRepresentante;

    @Column(name = "cpfRepresentante", unique = true, nullable = false)
    private String cpfRepresentante;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", unique = true, nullable = false)
    private String senha;

    public Instituicao() {}

    // Construtor sem id
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
