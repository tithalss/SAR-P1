package org.example.model; // Use o pacote adequado

public class LoginRequest {
    private String email;
    private String senha;

    // Construtor vazio (opcional, mas recomendado)
    public LoginRequest() {}

    // Construtor com parâmetros
    public LoginRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
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
