package org.example.repository;

import org.example.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
    Voluntario findByEmail(String email);
}
