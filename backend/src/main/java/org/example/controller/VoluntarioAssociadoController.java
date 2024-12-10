package org.example.controller;

import org.example.dao.VoluntarioAssociadoDAO;
import org.example.dto.VoluntarioDTO;
import org.example.model.VoluntarioAssociado;
import org.example.repository.VoluntarioAssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VoluntarioAssociadoController {
    @Autowired
    private VoluntarioAssociadoDAO voluntarioAssociadoDAO;
    @Autowired
    private VoluntarioAssociadoRepository voluntarioAssociadoRepository;

    @GetMapping("/voluntariosAssociados")
    public ResponseEntity<?> getAllVoluntariosAssociados() {
        try {
            List<VoluntarioAssociado> voluntariosAssociados = voluntarioAssociadoDAO.buscarTodosVoluntariosAssociados();

            List<VoluntarioDTO> voluntariosAssociadosDTO = voluntariosAssociados.stream()
                    .map(voluntario -> new VoluntarioDTO(
                            voluntario.getNomeCompleto(),
                            voluntario.getDataNascimento(),
                            voluntario.getTelefone(),
                            voluntario.getFormacao(),
                            voluntario.getEmail()
                    ))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(voluntariosAssociadosDTO, HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum voluntario encontrado", HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao buscar voluntarios: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/desassociar")
    @Transactional
    public ResponseEntity<String> excluirVoluntarioAssociado(@RequestParam String email) {
        try {

            if (email == null || email.isEmpty()) {
                return new ResponseEntity<>("O campo 'email' é obrigatório.", HttpStatus.BAD_REQUEST);
            }

            VoluntarioAssociado voluntarioAlvo = voluntarioAssociadoDAO.buscarVoluntarioAssociadoPorEmail(email);

            if (voluntarioAlvo == null) {
                return new ResponseEntity<>("Nenhum voluntário encontrado com o e-mail fornecido.", HttpStatus.NOT_FOUND);
            }

            boolean isDeleted = voluntarioAssociadoDAO.excluirVoluntarioAssociadoPorEmail(voluntarioAlvo.getEmail());

            if (isDeleted) {
                return new ResponseEntity<>("Voluntário excluído com sucesso!", HttpStatus.CREATED);
            } else {
                throw new RuntimeException("Erro ao excluir o voluntário.");
            }
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum voluntário encontrado com o e-mail fornecido.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao desassociar voluntário: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countVoluntariosAssociados")
    public long countVoluntariosAssociado() {
        try {
            return voluntarioAssociadoRepository.count();
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum registro encontrado.", HttpStatus.NO_CONTENT).getStatusCodeValue();
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).getStatusCodeValue();
        }
    }
}
