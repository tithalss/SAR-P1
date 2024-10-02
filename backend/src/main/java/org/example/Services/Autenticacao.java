package org.example.Services;

import org.example.ClassesDAO.VoluntarioDAO;
import org.example.Voluntario;

public class Autenticacao {

    private VoluntarioDAO voluntarioDAO;

    public Autenticacao() {
        this.voluntarioDAO = new VoluntarioDAO();
    }

    public Voluntario autenticar(String email, String senha) {
        Voluntario voluntario = voluntarioDAO.buscarPorEmail(email);
        if (voluntario != null && voluntario.getSenha().equals(senha)) {
            return voluntario; // Autenticação bem-sucedida
        } else {
            return null; // Autenticação falhou
        }
    }
}
