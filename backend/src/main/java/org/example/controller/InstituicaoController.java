package org.example.controller;

import org.example.dao.InstituicaoDAO;
import org.example.model.Instituicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class InstituicaoController {

    @Autowired
    private InstituicaoDAO instituicaoDAO;

    @GetMapping("/empresa")
    public ResponseEntity<Object> getNomeEmpresa(@RequestParam int id) {
        try {
            Instituicao instituicao = instituicaoDAO.buscarInstituicaoPorId(id);
            String nomeEmpresa = instituicao.getNome();
            return ResponseEntity.ok(Map.of("nomeEmpresa", nomeEmpresa));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Erro ao buscar nome da empresa."));
        }
    }
}

