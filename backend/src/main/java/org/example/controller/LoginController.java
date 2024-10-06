package org.example.controller;

import org.example.dao.VoluntarioDAO;
import org.example.model.LoginRequest;
import org.example.model.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private VoluntarioDAO voluntarioDAO;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Voluntario voluntario = voluntarioDAO.buscarPorEmail(loginRequest.getEmail());

        if (voluntario != null && voluntario.getSenha().equals(loginRequest.getSenha())) {
            // Login bem-sucedido
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            // Login falhou
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos.");
        }
    }
}
