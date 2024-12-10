package org.example.repository;

import org.example.model.Instituicao;
import org.example.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {
    Instituicao findByEmail(String email);
    Instituicao findById(int id);
}
