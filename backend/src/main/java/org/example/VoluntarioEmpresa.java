package org.example;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "voluntario_empresa")
public class VoluntarioEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática do ID
    private int id;

    @Column(name = "nome_completo", nullable = false) // O nome da coluna no banco de dados
    private String nomeCompleto;

    @Column(name = "pais", nullable = false) // O nome da coluna no banco de dados
    private String pais;

    @Column(name = "documentacao", nullable = false) // O nome da coluna no banco de dados
    private String documentacao;

    @Column(name = "data_nascimento", nullable = false) // O nome da coluna no banco de dados
    private LocalDate dataNascimento;

    @Column(name = "telefone") // O nome da coluna no banco de dados
    private String telefone;

    @Column(name = "escolaridade") // O nome da coluna no banco de dados
    private String escolaridade;

    @Column(name = "formacao") // O nome da coluna no banco de dados
    private String formacao;

    @Column(name = "email", unique = true, nullable = false) // O nome da coluna no banco de dados
    private String email;

    @Column(name = "senha", nullable = false) // O nome da coluna no banco de dados
    private String senha;

    @Column(name = "id_instituicao", nullable = false) // O nome da coluna no banco de dados
    private int idInstituicao;

    public VoluntarioEmpresa() {}

    // Construtor sem id
    public VoluntarioEmpresa(String nomeCompleto, String pais, String documentacao, LocalDate dataNascimento, String telefone,
                             String escolaridade, String formacao, String email, String senha, int idInstituicao) {
        this.nomeCompleto = nomeCompleto;
        this.pais = pais;
        this.documentacao = documentacao;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.escolaridade = escolaridade;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
        this.idInstituicao = idInstituicao;
    }

    // Construtor com id
    public VoluntarioEmpresa(int id, String nomeCompleto, String pais, String documentacao, LocalDate dataNascimento, String telefone,
                             String escolaridade, String formacao, String email, String senha, int idInstituicao) {
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
        this.idInstituicao = idInstituicao;
    }

    // Getters e Setters
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

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }
}
