package org.example.repository;

import org.example.model.Instituicao;
import org.example.model.Refugiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugiadoRepository extends JpaRepository<Refugiado, Integer> {
    Refugiado findByEmail(String email);
}
