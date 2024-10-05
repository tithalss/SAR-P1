package org.example.service;

import org.example.model.Voluntario;
import org.example.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Autenticacao {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public Voluntario autenticar(String email, String senha) {
        // Lógica de autenticação
        Voluntario voluntario = voluntarioRepository.findByEmail(email);
        if (voluntario != null && voluntario.getSenha().equals(senha)) {
            return voluntario;
        }
        return null;
    }
}
