package org.example.controller;

import org.example.dao.InstituicaoDAO;
import org.example.model.Instituicao;
import org.example.model.Login;
import org.example.model.Instituicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private InstituicaoDAO instituicaoDAO;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        try {
            Instituicao instituicao = instituicaoDAO.buscarInstituicaoPorEmail(login.getEmail().trim());

            if (instituicao != null && instituicao.getSenha().trim().equals(login.getSenha().trim())) {
                return ResponseEntity.ok(Map.of(
                        "id", instituicao.getId(),
                        "nome", instituicao.getNome(),
                        "message", "Login realizado com sucesso!"
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Email ou senha inválidos."));
            }
        } catch (Exception e) {
            // Log do erro para facilitar o diagnóstico
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Ocorreu um erro inesperado ao realizar o login. Tente novamente mais tarde."));
        }
    }
}