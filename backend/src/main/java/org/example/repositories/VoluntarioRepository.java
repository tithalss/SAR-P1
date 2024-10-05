package org.example.repositories;

import org.example.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
    Voluntario findByEmail(String email);
}
