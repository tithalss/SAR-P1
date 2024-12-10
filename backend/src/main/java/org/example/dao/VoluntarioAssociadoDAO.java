package org.example.dao;

import org.example.model.VoluntarioAssociado;
import org.example.repository.VoluntarioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioEmpresaDAO {
    @Autowired
    private VoluntarioEmpresaRepository voluntarioEmpresaRepository;

    public VoluntarioAssociado inserirVoluntarioAssociado(VoluntarioAssociado voluntarioAssociado) {
        return voluntarioEmpresaRepository.save(voluntarioAssociado);
    }

    public List<VoluntarioAssociado> buscarTodosVoluntariosAssociados() {
        return voluntarioEmpresaRepository.findAll();
    }

    public VoluntarioAssociado buscarPorEmail(String email) {
        return voluntarioEmpresaRepository.findByEmail(email);
    }

    public void atualizarVoluntarioAssociado(VoluntarioAssociado voluntarioAssociado) {
        voluntarioEmpresaRepository.save(voluntarioAssociado);
    }

    public void excluirVoluntarioAssociado(int id) {
        voluntarioEmpresaRepository.deleteById(id);
    }
}
