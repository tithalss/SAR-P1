package org.example.repositories;

import org.example.Refugiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugiadoRepository extends JpaRepository<Refugiado, Integer> {
}
