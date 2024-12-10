package org.example.controller;

import org.example.dao.RefugiadoDAO;
import org.example.dto.RefugiadoDTO;
import org.example.model.Refugiado;
import org.example.repository.RefugiadoRepository;
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
public class RefugiadoController {

    @Autowired
    private RefugiadoDAO refugiadoDAO;

    @Autowired
    private RefugiadoRepository refugiadoRepository;

    @GetMapping("/refugiados")
    public ResponseEntity<?> getAllRefugiados() {
        try {
            List<Refugiado> refugiados = refugiadoDAO.buscarTodosRefugiados();

            List<RefugiadoDTO> refugiadosDTO = refugiados.stream()
                    .map(refugiado -> new RefugiadoDTO(
                            refugiado.getNomeCompleto(),
                            refugiado.getPais(),
                            refugiado.getDataNascimento(),
                            refugiado.getFormacao(),
                            refugiado.getEmail()
                    ))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(refugiadosDTO, HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum refugiado encontrado", HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao buscar refugiados: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countRefugiados")
    public long countRefugiados() {
        try {
            return refugiadoRepository.count();
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Nenhum registro encontrado.", HttpStatus.NO_CONTENT).getStatusCodeValue();
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).getStatusCodeValue();
        }
    }
}
