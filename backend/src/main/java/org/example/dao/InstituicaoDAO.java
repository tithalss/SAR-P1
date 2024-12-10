package org.example.dao;

import org.example.model.Instituicao;
import org.example.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituicaoDAO {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public Instituicao inserirInstituicao(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    public List<Instituicao> buscarTodasInstituicoes() {
        return instituicaoRepository.findAll();
    }

    public Instituicao buscarInstituicaoPorId(int id) {return instituicaoRepository.findById(id);}

    public Instituicao buscarInstituicaoPorEmail(String email) {
        return instituicaoRepository.findByEmail(email);
    }

    public Instituicao atualizarInstituicao(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    public void excluirInstituicao(int id) {
        instituicaoRepository.deleteById(id);
    }
}
