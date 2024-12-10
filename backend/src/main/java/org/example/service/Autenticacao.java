package org.example.service;

import org.example.model.Instituicao;
import org.example.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Autenticacao {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public Instituicao autenticar(String email, String senha) {
        Instituicao instituicao = instituicaoRepository.findByEmail(email);
        if (instituicao != null && instituicao.getSenha().equals(senha)) {
            return instituicao;
        }
        return null;
    }
}
