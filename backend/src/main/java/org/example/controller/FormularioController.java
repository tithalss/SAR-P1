package org.example.controller;

import org.example.dao.VoluntarioDAO;
import org.example.model.Voluntario;
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
public class FormularioController {

    @Autowired
    private VoluntarioDAO voluntarioDAO;

    @PostMapping("/formulario")
    public ResponseEntity<Object> formulario(@RequestBody Voluntario voluntario) {
        try {
            Voluntario checkVoluntario = voluntarioDAO.buscarPorEmail(voluntario.getEmail());
            if (checkVoluntario != null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro: o e-mail já está cadastrado."));
            }

            Voluntario voluntarioCreated = voluntarioDAO.inserirVoluntario(voluntario);
            if (voluntarioCreated != null) {
                return ResponseEntity.ok(Map.of("message", "Novo usuário cadastrado com sucesso."));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro ao cadastrar usuário."));
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar o formulário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Erro interno do servidor."));
        }
    }
}
