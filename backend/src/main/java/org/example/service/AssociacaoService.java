package org.example.service;

import org.example.dao.VoluntarioAssociadoDAO;
import org.example.dao.VoluntarioDAO;
import org.example.model.Voluntario;
import org.example.model.VoluntarioAssociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AssociacaoService {

    @Autowired
    private VoluntarioDAO voluntarioDAO;

    @Autowired
    private VoluntarioAssociadoDAO voluntarioAssociadoDAO;

    @PostMapping("/associar")
    @Transactional
    public ResponseEntity<String> associarVoluntario(@RequestParam String email) {
        try {

            if (email == null || email.isEmpty()) {
                return new ResponseEntity<>("O campo 'email' é obrigatório.", HttpStatus.BAD_REQUEST);
            }

            Voluntario voluntarioAlvo = voluntarioDAO.buscarVoluntarioPorEmail(email);
            if (voluntarioAlvo == null) {
                return new ResponseEntity<>("Nenhum voluntário encontrado com o e-mail fornecido.", HttpStatus.NOT_FOUND);
            }

            if (voluntarioAssociadoDAO.buscarVoluntarioAssociadoPorEmail(email) != null) {
                return new ResponseEntity<>("O voluntário já está associado.", HttpStatus.CONFLICT);
            }

            VoluntarioAssociado voluntarioAssociado = new VoluntarioAssociado();
            voluntarioAssociado.setNomeCompleto(voluntarioAlvo.getNomeCompleto());
            voluntarioAssociado.setCpf(voluntarioAlvo.getCpf());
            voluntarioAssociado.setDataNascimento(voluntarioAlvo.getDataNascimento());
            voluntarioAssociado.setTelefone(voluntarioAlvo.getTelefone());
            voluntarioAssociado.setFormacao(voluntarioAlvo.getFormacao());
            voluntarioAssociado.setEmail(voluntarioAlvo.getEmail());

            boolean isDeleted = voluntarioDAO.excluirVoluntario(voluntarioAlvo.getEmail());

            if (isDeleted) {
                voluntarioAssociadoDAO.inserirVoluntarioAssociado(voluntarioAssociado);
                return new ResponseEntity<>("Voluntário associado com sucesso!", HttpStatus.CREATED);
            } else {
                throw new RuntimeException("Erro ao excluir o voluntário.");
            }
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum voluntário encontrado com o e-mail fornecido.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao associar voluntário: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

