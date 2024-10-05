package org.example.dao;

import org.example.model.Refugiado;
import org.example.repository.RefugiadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefugiadoDAO {
    @Autowired
    private RefugiadoRepository refugiadoRepository;

    public Refugiado inserirRefugiado(Refugiado refugiado) {
        return refugiadoRepository.save(refugiado);
    }

    public List<Refugiado> buscarTodosRefugiados() {
        return refugiadoRepository.findAll();
    }

    public Refugiado atualizarRefugiado(Refugiado refugiado) {
        return refugiadoRepository.save(refugiado);
    }

    public void excluirRefugiado(int id) {
        refugiadoRepository.deleteById(id);
    }
}
