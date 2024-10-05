package org.example.ClassesDAO;

import org.example.Instituicao;
import org.example.repositories.InstituicaoRepository;
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

    public Instituicao atualizarInstituicao(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    public void excluirInstituicao(int id) {
        instituicaoRepository.deleteById(id);
    }
}
