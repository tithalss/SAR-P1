package org.example.dao;

import org.example.model.VoluntarioAssociado;
import org.example.repository.VoluntarioAssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioAssociadoDAO {
    @Autowired
    private VoluntarioAssociadoRepository voluntarioAssociadoRepository;

    public VoluntarioAssociado inserirVoluntarioAssociado(VoluntarioAssociado voluntarioAssociado) {
        return voluntarioAssociadoRepository.save(voluntarioAssociado);
    }

    public List<VoluntarioAssociado> buscarTodosVoluntariosAssociados() {
        return voluntarioAssociadoRepository.findAll();
    }

    public VoluntarioAssociado buscarVoluntarioAssociadoPorEmail(String email) {
        return voluntarioAssociadoRepository.findByEmail(email);
    }

    public void atualizarVoluntarioAssociado(VoluntarioAssociado voluntarioAssociado) {
        voluntarioAssociadoRepository.save(voluntarioAssociado);
    }

    public boolean excluirVoluntarioAssociadoPorEmail(String email) {
        voluntarioAssociadoRepository.deleteByEmail(email);
        return true;
    }
}
