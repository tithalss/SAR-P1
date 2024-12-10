package org.example.controller;

import org.example.dao.InstituicaoDAO;
import org.example.dao.RefugiadoDAO;
import org.example.dao.VoluntarioAssociadoDAO;
import org.example.dao.VoluntarioDAO;
import org.example.model.Instituicao;
import org.example.model.Refugiado;
import org.example.model.Voluntario;
import org.example.model.VoluntarioAssociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/formulario")
public class FormularioController {

    @Autowired
    private VoluntarioDAO voluntarioDAO;
    @Autowired
    private VoluntarioAssociadoDAO voluntarioAssociadoDAO;
    @Autowired
    private InstituicaoDAO instituicaoDAO;
    @Autowired
    private RefugiadoDAO refugiadoDAO;

    @PostMapping("/voluntario")
    public ResponseEntity<Object> formulario(@RequestBody Voluntario voluntario) {
        try {
            Voluntario checkVoluntario = voluntarioDAO.buscarVoluntarioPorEmail(voluntario.getEmail());
            if (checkVoluntario != null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro: o e-mail já está cadastrado."));
            }

            Voluntario voluntarioCreated = voluntarioDAO.inserirVoluntario(voluntario);
            if (voluntarioCreated != null) {
                return ResponseEntity.ok(Map.of("message", "Voluntário cadastrado com sucesso."));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro ao cadastrar voluntario."));
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar o formulário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Erro interno do servidor."));
        }
    }

    @PostMapping("/voluntarioAssociado")
    public ResponseEntity<Object> formulario(@RequestBody VoluntarioAssociado voluntarioAssociado) {
        try {
            VoluntarioAssociado checkVoluntarioAssociado = voluntarioAssociadoDAO.buscarVoluntarioAssociadoPorEmail(voluntarioAssociado.getEmail());
            if (checkVoluntarioAssociado != null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro: o e-mail já está cadastrado."));
            }

            VoluntarioAssociado voluntarioAssociadoCreated = voluntarioAssociadoDAO.inserirVoluntarioAssociado(voluntarioAssociado);
            if (voluntarioAssociadoCreated != null) {
                return ResponseEntity.ok(Map.of("message", "Voluntário cadastrado com sucesso."));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro ao cadastrar voluntario."));
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar o formulário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Erro interno do servidor."));
        }
    }

    @PostMapping("/instituicao")
    public ResponseEntity<Object> formulario(@RequestBody Instituicao instituicao) {
        try {
            Instituicao checkInstituicao = instituicaoDAO.buscarInstituicaoPorEmail(instituicao.getEmail());
            if (checkInstituicao != null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro: o e-mail já está cadastrado."));
            }

            Instituicao instituicaoCreated = instituicaoDAO.inserirInstituicao(instituicao);
            if (instituicaoCreated != null) {
                return ResponseEntity.ok(Map.of("message", "Novo usuário cadastrado com sucesso."));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro ao cadastrar usuário."));
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar o formulário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Erro interno do servidor."));
        }
    }

    @PostMapping("/refugiado")
    public ResponseEntity<Object> formulario(@RequestBody Refugiado refugiado) {
        try {
            Refugiado checkRefugiado = refugiadoDAO.buscarRefugiadoPorEmail(refugiado.getEmail());
            if (checkRefugiado != null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro: o e-mail já está cadastrado."));
            }

            Refugiado refugiadoCreated = refugiadoDAO.inserirRefugiado(refugiado);
            if (refugiadoCreated != null) {
                return ResponseEntity.ok(Map.of("message", "Refugiado cadastrado com sucesso."));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Erro ao cadastrar refugiado."));
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar o formulário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Erro interno do servidor."));
        }
    }
}
