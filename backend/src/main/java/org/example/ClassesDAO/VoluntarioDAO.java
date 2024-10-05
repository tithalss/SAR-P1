package org.example.ClassesDAO;

import org.example.Voluntario;
import org.example.repositories.VoluntarioRepository;
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

    public Voluntario buscarPorEmail(String email) {
        return voluntarioRepository.findByEmail(email);
    }

    public void atualizarVoluntario(Voluntario voluntario) {
        voluntarioRepository.save(voluntario);
    }

    public void excluirVoluntario(int id) {
        voluntarioRepository.deleteById(id);
    }
}
