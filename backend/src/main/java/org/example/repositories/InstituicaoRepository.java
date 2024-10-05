package org.example.repositories;

import org.example.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {
    // Você pode adicionar métodos customizados aqui, se necessário
}
