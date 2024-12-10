package org.example.controller;

import org.example.dao.InstituicaoDAO;
import org.example.dto.InstituicaoDTO;
import org.example.model.Instituicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EditarPerfilController {

    @Autowired
    private InstituicaoDAO instituicaoDAO;

    @GetMapping("/editarPerfil")
    public ResponseEntity<Object> getPerfil(@RequestParam int id) {
        try {
            Instituicao instituicao = instituicaoDAO.buscarInstituicaoPorId(id);

            if (instituicao != null) {
                InstituicaoDTO instituicaoDTO = new InstituicaoDTO(
                        instituicao.getNome(),
                        instituicao.getCnpj(),
                        instituicao.getCep(),
                        instituicao.getEmail(),
                        instituicao.getSenha()
                );

                return ResponseEntity.ok(instituicaoDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Instituição não encontrada."));
            }
        } catch (Exception e) {
            System.err.println("Erro ao recuperar o perfil: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Erro interno do servidor."));
        }
    }

    @PutMapping("/editarPerfil")
    public ResponseEntity<Object> editar(@RequestParam int id, @RequestBody InstituicaoDTO instituicaoDTO) {
        try {
            Instituicao instituicao = instituicaoDAO.buscarInstituicaoPorId(id);

            if (instituicao == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Instituição não encontrada."));
            }

            if (!instituicao.getSenha().equals(instituicaoDTO.getSenha())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Senha antiga incorreta."));
            }

            instituicao.setNome(instituicaoDTO.getNome());
            instituicao.setEmail(instituicaoDTO.getEmail());
            instituicao.setCnpj(instituicaoDTO.getCnpj());
            instituicao.setCep(instituicaoDTO.getCep());

            if (instituicaoDTO.getNovaSenha() != null && !instituicaoDTO.getNovaSenha().isBlank()) {
                instituicao.setSenha(instituicaoDTO.getNovaSenha());
            }

            instituicaoDAO.atualizarInstituicao(instituicao);

            return ResponseEntity.ok(Map.of("message", "Perfil atualizado com sucesso."));
        } catch (Exception e) {
            System.err.println("Erro ao atualizar dados: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Erro interno do servidor."));
        }
    }
}
