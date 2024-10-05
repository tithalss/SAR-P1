package org.example.Services;

import org.example.Voluntario;
import org.example.repositories.VoluntarioRepository;
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
