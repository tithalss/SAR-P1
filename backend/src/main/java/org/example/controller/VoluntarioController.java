package org.example.controller;

import org.example.dao.VoluntarioAssociadoDAO;
import org.example.dao.VoluntarioDAO;
import org.example.dto.VoluntarioDTO;
import org.example.model.Voluntario;
import org.example.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VoluntarioController {
    @Autowired
    private VoluntarioDAO voluntarioDAO;
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @GetMapping("/voluntarios")
    public ResponseEntity<?> getAllVoluntarios() {
        try {
            List<Voluntario> voluntarios = voluntarioDAO.buscarTodosVoluntarios();

            List<VoluntarioDTO> voluntariosDTO = voluntarios.stream()
                    .map(voluntario -> new VoluntarioDTO(
                            voluntario.getNomeCompleto(),
                            voluntario.getDataNascimento(),
                            voluntario.getTelefone(),
                            voluntario.getFormacao(),
                            voluntario.getEmail()
                    ))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(voluntariosDTO, HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum voluntario encontrado", HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao buscar voluntarios: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countVoluntarios")
    public long countVoluntarios() {
        try {
            return voluntarioRepository.count();
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum registro encontrado.", HttpStatus.NO_CONTENT).getStatusCodeValue();
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).getStatusCodeValue();
        }
    }
}
