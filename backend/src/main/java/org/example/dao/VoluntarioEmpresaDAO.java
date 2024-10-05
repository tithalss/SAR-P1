package org.example.dao;

import org.example.model.VoluntarioEmpresa;
import org.example.repository.VoluntarioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioEmpresaDAO {
    @Autowired
    private VoluntarioEmpresaRepository voluntarioEmpresaRepository;

    public VoluntarioEmpresa inserirVoluntarioAssociado(VoluntarioEmpresa voluntarioEmpresa) {
        return voluntarioEmpresaRepository.save(voluntarioEmpresa);
    }

    public List<VoluntarioEmpresa> buscarTodosVoluntariosAssociados() {
        return voluntarioEmpresaRepository.findAll();
    }

    public VoluntarioEmpresa buscarPorEmail(String email) {
        return voluntarioEmpresaRepository.findByEmail(email);
    }

    public void atualizarVoluntarioAssociado(VoluntarioEmpresa voluntarioEmpresa) {
        voluntarioEmpresaRepository.save(voluntarioEmpresa);
    }

    public void excluirVoluntarioAssociado(int id) {
        voluntarioEmpresaRepository.deleteById(id);
    }
}
