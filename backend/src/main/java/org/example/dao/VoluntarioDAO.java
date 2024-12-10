package org.example.dao;

import org.example.model.Voluntario;
import org.example.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoluntarioDAO {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public Voluntario inserirVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    public List<Voluntario> buscarTodosVoluntarios() {
        return voluntarioRepository.findAll();
    }

    public Voluntario buscarVoluntarioPorEmail(String email) {
        return voluntarioRepository.findByEmail(email);
    }

    public void atualizarVoluntario(Voluntario voluntario) {
        voluntarioRepository.save(voluntario);
    }

    public boolean excluirVoluntario(String email) {
        voluntarioRepository.deleteByEmail(email);
        return true;
    }
}
